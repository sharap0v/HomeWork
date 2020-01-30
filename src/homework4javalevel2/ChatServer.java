package homework4javalevel2;

import javax.swing.*;
import java.io.*;

public class ChatServer {
    public void start(int port) {
        System.out.println("Server started at port: " + port);
    }

    public void stop() {
        System.out.println("Server stopped");
    }
    private static void logging(String message) {
        try(FileOutputStream log=new FileOutputStream("logFile.txt",true))
        {
            // перевод строки в байты
            byte[] buffer = message.getBytes();

            log.write(buffer, 0, buffer.length);
            log.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    private static String readlog() {
        String lastMessage = null;
        String lastMessageOld =null;
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("logFile.txt"));
            while ((lastMessage = in.readLine()) != null)
            {
                lastMessageOld = lastMessage;
                /*
                * тут полюбому скажут что это долго и так далее
                * но подругому я пока что незнаю как
                * то что log должен грузится с сервера а не заполняться напрямую пользователем в этом я уверен
                * методы пока что статик для того чтобы все работало
                * сервер должен получить log при создании поидее и установить log.setEditable(false)
                * опять же мои догадки в силу отсутствия опыта
                * я установил это в клиент гуи))))))*/
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return lastMessageOld+"\n";
    }
    public static void sendMessage(JTextField tfLogin,JTextField tfMessage, JTextArea log){
        ChatServer.logging(tfLogin.getText()+": "+ tfMessage.getText()+"\n");
        log.append(ChatServer.readlog());
        tfMessage.setText("");
    }
}