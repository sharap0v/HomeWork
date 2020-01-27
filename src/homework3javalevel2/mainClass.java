package homework3javalevel2;

import java.util.*;

public class mainClass {
    /*
     1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
  - Найти список слов, из которых состоит текст (дубликаты не считать);
  - Посчитать сколько раз встречается каждое слово (использовать HashMap);

     */

    public static String[] arrays = {"January", "February","April","March","June", "June", "June", "June", "July","August","September","October","November","December","January", "February","April","March","May","June","July","August","September","October","November","December"};

    public static void main(String[] args) {

        System.out.println(wordList(arrays));
        System.out.println(wordCount(arrays));
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Петров", "petrov@ya.ru", "8900000000");//тут все добавляется
        phoneBook.add("Петров", "petrov96@ya.ru", "8906666666");
        phoneBook.add("Сидоров", "sidorov@ya.ru", "890616161616");
        System.out.println(phoneBook.getEmail("Петров"));// тут все коректно ищется
        System.out.println(phoneBook.getPhone("петров"));
        System.out.println(phoneBook.getPhone("сидоров"));

    }
    public static Set<String> wordList(String[] array){
        return new HashSet<>(Arrays.asList(array));
    }
    public static Map<String,Integer> wordCount(String[] array){
        Map<String,Integer> map = new HashMap<>();
        for (String arra : mainClass.wordList(array)){
            int i = 0;
            for (String arr: array){
                if(arra.equals(arr)){
                    i++;
                }
            }
            map.put(arra, i);
        }
        return map;
    }
}
