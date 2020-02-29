package ru.gb.jt.chat.server.core;

import ru.gb.jt.chat.common.Library;
import ru.gb.jt.network.ServerSocketThread;
import ru.gb.jt.network.ServerSocketThreadListener;
import ru.gb.jt.network.SocketThread;
import ru.gb.jt.network.SocketThreadListener;

import javax.sql.RowSetListener;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

public class ChatServer implements ServerSocketThreadListener, SocketThreadListener {

    private final ChatServerListener listener;
    private ServerSocketThread server;
    private final DateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss: ");
    private Vector<SocketThread> clients = new Vector<>();
    private HashSet<String> censure;
    {//создается множество нежелательных слов
        try(FileReader fileReader = new FileReader("censorship.txt")){
            BufferedReader reader = new BufferedReader(fileReader);
             censure = new HashSet<>();
            while (reader.ready()){
                censure.add(reader.readLine());}
        }
        catch (IOException e){
            censure = null;
        }
    }

    public ChatServer(ChatServerListener listener) {
        this.listener = listener;
    }

    public void start(int port) {
        if (server != null && server.isAlive())
            putLog("Server already started");
        else
            server = new ServerSocketThread(this, "Server", port, 2000);
    }

    public void stop() {
        if (server == null || !server.isAlive()) {
            putLog("Server is not running");
        } else {
            server.interrupt();
        }
    }

    private void putLog(String msg) {
        msg = DATE_FORMAT.format(System.currentTimeMillis()) +
                Thread.currentThread().getName() + ": " + msg;
        listener.onChatServerMessage(msg);

    }
    private void writeServerLog(String msg) {
        File file = new File("Serverlog.txt");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            writer.write(msg+"\n");
        }
        catch (IOException e){

            }
        }


    /**
     * Server methods
     *
     * */

    @Override
    public void onServerStart(ServerSocketThread thread) {
        putLog("Server thread started");
        SqlClient.connect();
    }

    @Override
    public void onServerStop(ServerSocketThread thread) {
        putLog("Server thread stopped");
        SqlClient.disconnect();
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).close();
        }

    }

    @Override
    public void onServerSocketCreated(ServerSocketThread thread, ServerSocket server) {
        putLog("Server socket created");

    }

    @Override
    public void onServerTimeout(ServerSocketThread thread, ServerSocket server) {
//        putLog("Server timeout");

    }

    @Override
    public void onSocketAccepted(ServerSocketThread thread, ServerSocket server, Socket socket) {
        putLog("Client connected");
        String name = "SocketThread " + socket.getInetAddress() + ":" + socket.getPort();
        new ClientThread(this, name, socket);

    }

    @Override
    public void onServerException(ServerSocketThread thread, Throwable exception) {
        exception.printStackTrace();
    }

    /**
     * Socket methods
     *
     * */

    @Override
    public synchronized void onSocketStart(SocketThread thread, Socket socket) {
        putLog("Socket created");

    }

    @Override
    public synchronized void onSocketStop(SocketThread thread) {
        ClientThread client = (ClientThread) thread;
        clients.remove(thread);
        if (client.isAuthorized() && !client.isReconnecting() ) {
            sendToAuthClients(Library.getTypeBroadcast("Server",
                    client.getNickname() + " disconnected"));
        }
        sendToAuthClients(Library.getUserList(getUsers()));
    }

    @Override
    public synchronized void onSocketReady(SocketThread thread, Socket socket) {
        clients.add(thread);


    }

    @Override
    public synchronized void onReceiveString(SocketThread thread, Socket socket, String msg) {
        ClientThread client = (ClientThread) thread;
        if (client.isAuthorized()) {
            handleAuthMessage(client, msg);
        } else {
            handleNonAuthMessage(client, msg);
        }
    }

    private void handleNonAuthMessage(ClientThread client, String msg) {
        String[] arr = msg.split(Library.DELIMITER);
        if (arr.length != 3 || !arr[0].equals(Library.AUTH_REQUEST)) {
            client.msgFormatError(msg);
            return;
        }
        String login = arr[1];
        String password = arr[2];
        String nickname = SqlClient.getNickname(login, password);
        if (nickname == null) {
            putLog("Invalid login attempt: " + login);
            client.authFail();
            return;
        } else {
            ClientThread oldClient = findClientByNickname(nickname);
            client.authAccept(nickname);
            sendToClientLastMessage(readFromLogFileLast100Message("Serverlog.txt"), client);
            if (oldClient == null) {
                sendToAuthClients(Library.getTypeBroadcast("Server", nickname + " connected"));
            } else {
                oldClient.reconnect();
                clients.remove(oldClient);
            }

        }
        sendToAuthClients(Library.getUserList(getUsers()));
    }
    //3. Добавить "цензуру"
    public String censorship(String msg){
        String[] badstring = msg.split(" ");
        String goodstring ="";
        if(censure!=null){
        for (int i = 0 ; i<badstring.length; i++){
            if(censure.contains(badstring[i])){
                String[] strings = badstring[i].split("");
                String fake ="";
                for(int p =0; p<strings.length-2;p++){
                    fake+="*";
                }
                goodstring= goodstring + strings[0]+fake+strings[strings.length-1];
            }
            else{
                goodstring = goodstring + " "+ badstring[i];
            }
        }}
        else{
            goodstring = msg;
        }
        return goodstring;
    }


    private void handleAuthMessage(ClientThread client, String msg) {
        String[] arr = msg.split(Library.DELIMITER);
        String msgType = arr[0];
        switch (msgType) {
            case Library.TYPE_BCAST_CLIENT:
                sendToAuthClients(Library.getTypeBroadcast(
                        client.getNickname(), censorship(arr[1])));
                break;
            case Library.CHANGE_NICK:
                String login = arr[1];
                String newNickname = arr[2];
                SqlClient.changeNickname(newNickname, login);
                break;

            default:
                client.sendMessage(Library.getMsgFormatError(msg));
        }
    }
// launch4j
    private void sendToAuthClients(String msg) {
        for (int i = 0; i < clients.size(); i++) {
            ClientThread client = (ClientThread) clients.get(i);
            if (!client.isAuthorized()) continue;
            client.sendMessage(msg);
        }
        writeServerLog(msg);
    }
    //Отправляем сообщение авторизовавшемуся клиенту
    private void sendToClientLastMessage(LinkedList<String> log, ClientThread client) {

            //if (client.isAuthorized()){
                for (String msg: log){
            client.sendMessage(msg);}
    }
    private LinkedList readFromLogFileLast100Message(String filename){
        LinkedList<String> log = new LinkedList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            while (reader.ready()){
            log.addLast(reader.readLine());
            if(log.size()>=101){
                log.remove(1);
            } } }
        catch (IOException e){
        }
        return log;
    }

    @Override
    public synchronized void onSocketException(SocketThread thread, Exception exception) {
        exception.printStackTrace();
    }

    private String getUsers() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < clients.size(); i++) {
            ClientThread client = (ClientThread) clients.get(i);
            if (!client.isAuthorized()) continue;
            sb.append(client.getNickname()).append(Library.DELIMITER);
        }
        return sb.toString();
    }

    private synchronized ClientThread findClientByNickname(String nickname) {
        for (int i = 0; i < clients.size(); i++) {
            ClientThread client = (ClientThread) clients.get(i);
            if (!client.isAuthorized()) continue;
            if (client.getNickname().equals(nickname))
                return client;
        }
        return null;
    }

}
