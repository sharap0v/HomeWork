import java.util.SortedMap;

public class homework2 {

    public static int [] massiv = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
    public static void invertor(int[] massiv){
        /*1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
        for(int i =0; i < massiv.length; i++){
            if (massiv[i]==0)
            {
                massiv[i]=1;
            }
            else if (massiv[i]==1)
            {
                massiv[i]=0;
            }
        }
    }
    public static void primtMassiv(int[]massiv){

        for (int mass: massiv) {
            System.out.print(" " + mass);
        }
        System.out.println();
    }
    /*2. Задать пустой целочисленный массив размером 8.
     С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;*/
    public static int[] massiv2 = new int[8];
    public static void createMassiv(int[] massiv2){
        int item = 0;
        for(int i = 0; i < massiv2.length; i++){
            massiv2[i] = item;
            item+=3;
        }
    }
    /*
    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    public static int [] massiv3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
    public static void multiplicationByTwo(int[] massiv3){
        for(int i = 0; i < massiv3.length; i++)
    {
        if (massiv3[i]<6)
            massiv3[i]=massiv3[i]*2;
    }
    }
    /*4. Создать квадратный двумерный целочисленный массив
    (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
    заполнить его диагональные элементы единицами;*/
    public static int[][] createSquare(int x, int y){
         int[][] square = new int[x][y];
        for (int i = 0; i < x; i++){
            for (int c = 0; c < y; c++){
                square[i][x-1-i] = 1;
                square[i][i] = 1;
            }
        }
        return square;
    }
    public static void printSquare(int[][] square){
        for(int i = 0; i < square.length; i++ ){
            for(int c = 0; c < square[i].length; c++){
                System.out.print(square[i][c]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    /*
    5. ** Задать одномерный массив и найти в нем минимальный
     и максимальный элементы (без помощи интернета);на случай
     если минимальных элементов или максимальных больше чем 1 метод
      выведет индекс каждого
     */
    public static void minMax(int[] massiv){
        int min = massiv[0];
        int max = massiv[0];
        for (int i = 1; i < massiv.length; i++){
            if(massiv[i]< min){
                min = massiv[i];
            }
            if (massiv[i] > max){
                max = massiv[i];
            }
        }
        System.out.print("Минимальный элемент массива равен " + min + " его индекс(индексы):");
        for (int i = 0; i < massiv.length; i++){
            if(massiv[i]==min){
                System.out.print(" ");
                System.out.print(i);
            }
        }
        System.out.println();
        System.out.print("Максимальный элемент массива равен " + max + " его индекс(индексы):");
        for (int i = 0; i < massiv.length; i++){
            if(massiv[i]==max){
                System.out.print(" ");
                System.out.print(i);
            }
        }
    }
    /*
    6. ** Написать метод, в который передается не пустой одномерный
     целочисленный массив, метод должен вернуть true, если в массиве
    есть место, в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
    эти символы в массив не входят.
     */
    public static boolean checkBalance(int[] massiv){
        int left = massiv[0];
        int right = 0;
        for(int i = 1; i < massiv.length; i++ ){
            right = right+massiv[i];
        }
        for(int c = 1; c < massiv.length-1; c++ ){
            if( left==right){
                return true;
            }
            else {
                left = left + massiv[c];
                right = right - massiv[c];
            }
        }
        return false;
    }
    /*
    7. **** Написать метод, которому на вход подается одномерный массив
     и число n (может быть положительным, или отрицательным), при этом
     метод должен сместить все элементымассива на n позиций. Для усложнения
    задачи нельзя пользоваться вспомогательными массивами.
    пример [0,0,0,0,0,5,0,0,0,1,9] -> на 2 сдвигаем [1,9,0,0,0,0,0,5,0,0,0]
     */
    public static void shift(int[] massiv, int n){
        int p;
        if (n>0) {
            // n положительное двигаем вправо
            for (int i = 0; i < n; i++) {
                p = massiv[massiv.length - i - 1];
                for (int g = massiv.length - 1; g > 0; g--) {
                    massiv[g] = massiv[g - 1];
                }
                massiv[0] = p;
            }
        }
        else {
            // n отрицательное двигаем в лево
            for (int i = n; i < 0; i++) {
                p = massiv[0];
                for (int g = 0; g < massiv.length-1; g++) {
                    massiv[g] = massiv[g + 1];
                }
                massiv[massiv.length-1] = p;
        }}
    }
    public static void main(String[] args)  {
        System.out.println("Задача 1");
        primtMassiv(massiv);
        invertor(massiv);
        primtMassiv(massiv);
        System.out.println("Задача 2");
        primtMassiv(massiv2);
        createMassiv(massiv2);
        primtMassiv(massiv2);
        System.out.println("Задача 3");
        primtMassiv(massiv3);
        multiplicationByTwo(massiv3);
        primtMassiv(massiv3);
        System.out.println("Задача 4");
        printSquare(createSquare(5, 5));
        System.out.println("Задача 5");
        minMax(massiv3);
        System.out.println();
        System.out.println("Задача 6");
        System.out.println(checkBalance(massiv3));
        System.out.println(checkBalance(massiv2));
        System.out.println("Задача 7");
        primtMassiv(massiv3);
        System.out.println("сдвиг в право");
        shift(massiv3, 4);
        primtMassiv(massiv3);
        System.out.println("сдвиг в лево");
        shift(massiv3, -7);
        primtMassiv(massiv3);









    }
}