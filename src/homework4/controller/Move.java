package homework4.controller;

import homework4.RunGame;

import static homework4.RunGame.board;

public class Move {
    public static final String MOVE_X = "X";
    public static final String MOVE_0 = "0";

    private static void setList(int movePlayer, String move) {
        if (movePlayer < (board.getSize() * board.getSize())){
            System.out.println(move);
            if (movePlayer >= 0 && (board.getList()[movePlayer / board.getSize()][movePlayer % board.getSize()]).equals("▢")) {
                board.getList()[movePlayer/board.getSize()][movePlayer%board.getSize()] = move;
            } else {

                throw new NumberFormatException("NEN");
            }}
        else {
            throw new NumberFormatException("DDDDDDD");
        }
        checkWin(move);

    }
    public static void userMove(int movePlayer){setList(movePlayer, MOVE_X);}
    public static void iIMove(int movePlayer){setList(movePlayer, MOVE_0);}
    private static void WinMessage(String move){
        System.out.println( "Игрокк играющий за " + move + " Выиграл" );RunGame.win = true;
    }

    /*
    2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
    3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек
    4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
     */
    /*
    Проверка победы работает даже для поля 100 на 100.
    для поля 3 на 3 победа будет 3 в ряд
    для поля больше 3 победой является 4 в ряд
     */
    public static void checkWin(String move) throws ArrayIndexOutOfBoundsException{
        for (int i = 0; i < board.getSize(); i++){
            for(int b = 0; b< board.getSize(); b++){
                if (board.getSize()==3){
                    if(b+2<=board.getSize()-1){
                    if (board.getList()[i][b].equals(move) && board.getList()[i][b+1].equals(move) && board.getList()[i][b+2].equals(move)){
                        WinMessage(move);}}
                    if(i+2<=board.getSize()-1){
                    if(board.getList()[i][b].equals(move) && board.getList()[i+1][b].equals(move) && board.getList()[i+2][b].equals(move)){
                        WinMessage(move);}}
                    if(i+2<=board.getSize()-1&&b+2<=board.getSize()-1){
                    if(board.getList()[i][b].equals(move) && board.getList()[i+1][b+1].equals(move) && board.getList()[i+2][b+2].equals(move)){
                        WinMessage(move);}}
                    if(i+2<=board.getSize()-1 && b-2>=0){
                    if(board.getList()[i][b].equals(move) && board.getList()[i+1][b-1].equals(move) && board.getList()[i+2][b-2].equals(move)){
                        WinMessage(move);}}
                }
                else {
                    if(b+3<=board.getSize()-1){
                    if (board.getList()[i][b].equals(move) & board.getList()[i][b+1].equals(move) & board.getList()[i][b+2].equals(move) & board.getList()[i][b+3].equals(move)){
                        WinMessage(move);}}
                    if(i+3<=board.getSize()-1){
                    if(board.getList()[i][b].equals(move) & board.getList()[i+1][b].equals(move) & board.getList()[i+2][b].equals(move) & board.getList()[i+3][b].equals(move)){
                        WinMessage(move);}}
                    if(i+3<=board.getSize()-1&&b+3<=board.getSize()-1){
                    if(board.getList()[i][b].equals(move) & board.getList()[i+1][b+1].equals(move) & board.getList()[i+2][b+2].equals(move) & board.getList()[i+3][b+3].equals(move)){
                        WinMessage(move);}}
                    if(i+3<=board.getSize()-1 && b-3>=0){
                    if(board.getList()[i][b].equals(move) & board.getList()[i+1][b-1].equals(move) & board.getList()[i+2][b-2].equals(move) & board.getList()[i+3][b-3].equals(move)){
                        WinMessage(move);}}
                }
            }
        }
    }
}
