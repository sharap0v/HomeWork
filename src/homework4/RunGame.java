package homework4;

import homework4.AI.AI;
import homework4.view.Board;
import homework4.controller.Move;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RunGame {

    public static int  size;
    public static int movePlayer = -1;
    public static boolean move = true;
    public static boolean win = false;
    public  static Board board;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("начнем игру крестики нолики");
        while(size == 0) {
            try {
                System.out.println("Введите размер поля!");
                size = Integer.parseInt(reader.readLine());

            } catch (NumberFormatException e) {
                System.out.println("Вводить необходимо только целые числа!");
                continue;
            }
        }
            board = new Board(size);
        System.out.println("Ты играешь крестиками твоя задача обыграть Искуственный Интелект))");
        System.out.println("Bыбери место куда необходимо поставить крестик согласно приведенному примеру нумерации");
        board.printDemoBoard();
        board.printBoard();
        while(!win) {
            try {
                if (move) {
                    System.out.println("Ход игрока");
                    movePlayer = Integer.parseInt(reader.readLine());
                    Move.userMove(movePlayer);
                    move = false;
                } else {
                    System.out.println("Ход компьютера");
                    AI.aiThink();
                    movePlayer = AI.getCoordinat();
                    Move.iIMove(movePlayer);
                    move = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("такой ход недопустим");
            }
            board.printBoard();
            board.checkBoard();
        }
        System.out.println("Игра завершена");


}}