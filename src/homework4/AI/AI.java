package homework4.AI;


import java.util.Random;

import static homework4.RunGame.board;
import static homework4.controller.Move.MOVE_X;

public class AI {


    static Random random = new Random();
    public static int coordinat;
/*
4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
 */
    public static void aiThink() {
        String move = MOVE_X;
        coordinat = -1;

            for (int i = 0; i < board.getSize(); i++) {
                for (int b = 0; b < board.getSize(); b++) {
                    if(b+2<=board.getSize()-1){
                        if (board.getList()[i][b].equals(move) & board.getList()[i][b + 1].equals(move) & board.getList()[i][b + 2].equals("▢")) {
                            coordinat = board.getSize() * i + b + 2;
                            System.out.println("1 обработка");
                        }
                    }
                    if(i+2<=board.getSize()-1){
                        if (board.getList()[i][b].equals(move) & board.getList()[i + 1][b].equals(move) & board.getList()[i + 2][b].equals("▢")) {
                            coordinat = board.getSize() * (i + 2) + b;
                            System.out.println("2 обработка");
                        }
                    }
                    if(i+2<=board.getSize()-1 && b+2<=board.getSize()-1){
                        if (board.getList()[i][b].equals(move) & board.getList()[i + 1][b + 1].equals(move) & board.getList()[i + 2][b + 2].equals("▢")) {
                            coordinat = board.getSize() * (i + 2) + b + 2;
                            System.out.println("3 обработка");
                        }
                    }
                    if(i+2<=board.getSize()-1 && b-2>=0){
                        if (board.getList()[i][b].equals(move) & board.getList()[i + 1][b - 1].equals(move) & board.getList()[i][b - 2].equals("▢")) {
                            coordinat = board.getSize() * i + b - 2;
                            System.out.println("4 обработка");
                        }
                    }
                    if(b+3<=board.getSize()-1 && b+2<=board.getSize()-1){
                        if ((board.getList()[i][b].equals(move) & board.getList()[i][b + 1].equals(move) & board.getList()[i][b + 2].equals(move) & board.getList()[i][b + 3].equals("▢"))) {
                            coordinat = board.getSize() * i + b + 3;
                            System.out.println("5 обработка");
                        }
                    }
                    if(i+2<=board.getSize()-1 && i+3<=board.getSize()-1){
                        if (board.getList()[i][b].equals(move) & board.getList()[i + 1][b].equals(move) & board.getList()[i + 2][b].equals(move) & board.getList()[i + 3][b].equals("▢")) {
                            coordinat = board.getSize() * (i + 3) + b;
                            System.out.println("6 обработка");
                        }
                    }
                    if(i+2<=board.getSize()-1 && b+2<=board.getSize()-1 && i+3<=board.getSize()-1 && b+3<=board.getSize()-1){
                        if (board.getList()[i][b].equals(move) & board.getList()[i + 1][b + 1].equals(move) & board.getList()[i + 2][b + 2].equals(move) & board.getList()[i + 3][b + 3].equals("▢")) {
                            coordinat = board.getSize() * (i + 3) + b + 3;
                            System.out.println("7 обработка");
                        }
                    }
                    if(i+2<=board.getSize()-1 && b-2>=0 && i+3<=board.getSize()-1 && b-3>=0){
                        if (board.getList()[i][b].equals(move) & board.getList()[i + 1][b - 1].equals(move) & board.getList()[i][b - 2].equals(move) & board.getList()[i][b - 3].equals("▢")) {
                            coordinat = board.getSize() * i + b - 3;
                            System.out.println("8 обработка");
                        }
                    }
                    if(coordinat == -1){
                        coordinat = random.nextInt(board.getSize() * board.getSize()-1);
                        System.out.println("рандомный ход");
                    }
                }
            }
    }

    public static int getCoordinat() {
        return coordinat;
    }
}


