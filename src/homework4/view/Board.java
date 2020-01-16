package homework4.view;
import homework4.RunGame;

public class Board {

    private String[][]list;
    private int size;

    public int getSize() {
        return size;
    }
    public String[][] getList() {
        return list;
    }



    public Board(int size) {
        if (size<3){
        this.size = 3;}
        else {
            this.size = size;
        }
        list = new String[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int b = 0; b < this.size; b++) {
                list[i][b] = "▢";
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < this.size; i++){
            for(int b = 0; b< this.size; b++){
                System.out.print(this.list[i][b]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void checkBoard() {
        int check=0;
        for (int i = 0; i < this.size; i++){
            for(int b = 0; b< this.size; b++){
                if (list[i][b].equals("▢")) {
                    check++;
                }
            }
        }
        if(check == 0){
            System.out.println("Ходов больше не осталось");
            RunGame.win = true;
        }
    }
    public void printDemoBoard() {
        for (int i = 0; i < this.size*this.size; i=i+this.size){
            int b = 0;
            while (b<this.size){
                if(i+b<10){
                    System.out.print(" "+(i+b)+ " ");
                }
                else {
                System.out.print((i+b)+ " ");}
                b++;}
            System.out.println();
        }
    }
}