package homework6javalewel3;

public class metod {

    /*Написать метод, которому в качестве аргумента передается не пустой
     одномерный целочисленный массив. Метод должен вернуть новый массив,
     который получен путем вытаскивания из исходного массива элементов,
     идущих после последней четверки. Входной массив должен содержать хотя
     бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
     Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
    */
    public static int [] metodd(int[] massiv){
        int index = -1;
        int [] newmassiv;
        for(int i = 0; i<massiv.length; i++){
            if(massiv[i]==4){
                index = i;
            }
        }
        if(index==-1){
            throw new RuntimeException();
        }
        else {
            newmassiv = new int[massiv.length-index-1];
            for (int i = 0; i<newmassiv.length; i++){
                newmassiv[i]=massiv[i+index+1];
            }
        }
        return newmassiv;
    }
    public static boolean metod2(int[] massiv){
        boolean r = false;
        int i1=0;
        int i4=0;
        for(int i = 0; i<massiv.length; i++)
        {
            if(massiv[i] ==4){
                i4++;
            }
            if(massiv[i] == 1){
                i1++;
            }
            if(massiv[i] != 1&&massiv[i] !=4){
                return r;
            }
        }
        if(i4>0&&i1>0){
            r=true;
        }
        return r;
    }
}
