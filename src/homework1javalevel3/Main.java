package homework1javalevel3;

import java.sql.Array;
import java.util.ArrayList;

public class Main {
    public static void changeElement(Object[] array, int firs, int second) {
        Object object;
        object = array[firs];
        array[firs] = array[second];
        array[second] = object;
        //1. Написать метод, который меняет два элемента массива местами.
        // (массив может быть любого ссылочного типа);
        //Надеюсь я правильно понял задание.....
    }

    public static ArrayList transformToArrayList(Object[] array) {
        ArrayList arays = new ArrayList();
            for (int i = 0; i<array.length; i++){
                arays.add(array[i]);
            }
                return arays;
        //Collections.addAll(arays, array);Поидее как я понимаю можно так было
        //Написать метод, который преобразует массив в ArrayList;
    }
}
