import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class homework3 {
    /*Написать программу, которая загадывает случайное число от 0 до 9
    и пользователю дается 3 попытки угадать это число. При каждой попытке
    компьютер должен сообщить, больше ли указанное пользователем число,
     чем загаданное, или меньше. После победы или проигрыша выводится запрос
      – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    */
    public static void main(String[] args) throws IOException{
        gameOne();
    }
    public static void gameOne()throws IOException{
        Random random = new Random();
        int a = random.nextInt(10);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int ansver;
        boolean bool = true;
        while (bool) {
            System.out.println("Отгадай число от 0 до 9 ");
            for (int i = 3; i > 0; i--) {
                System.out.println("У Вас " + i + " попытки");
                try {
                    ansver = Integer.parseInt(reader.readLine());
                    if (ansver == a) {
                        System.out.println("Правильно это число " + a);
                    } else if (ansver < a) {
                        System.out.println("Загаданное число больше " + ansver);
                    } else if (ansver > a) {
                        System.out.println("Загаданное число меньше " + ansver);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Вводить необходимо только цифры");
                }
            }
            System.out.println("«Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)");

            while (true) {
                try {
                    ansver = Integer.parseInt(reader.readLine());
                    if (ansver == 1) {
                        bool = true;
                        break;
                    } else if (ansver == 0) {
                        bool = false;
                        System.out.println("Программа завершается");
                        break;
                    }
                    else System.out.println("«Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)");
                } catch (NumberFormatException e) {
                    System.out.println("Вводить необходимо только цифры");
                }
            }
        }
        reader.close();
    }

        public static void gameToo()
        {
            //String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};


            /*
            * Создать массив из слов
    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
            При запуске программы компьютер загадывает слово,
             запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает,
             правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы,
             которые стоят на своих местах.
    apple – загаданное
    apricot - ответ игрока
    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    Для сравнения двух слов посимвольно можно пользоваться:
    String str = "apple";
    char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    Играем до тех пор, пока игрок не отгадает слово.
    Используем только маленькие буквы.*/
        }


    }




