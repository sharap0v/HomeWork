package homework2javalevel2;


import java.io.IOException;


public class main {
    /*
     1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
 10 3 1 2
 2 3 2 2
 5 6 7 1
 300 3 1 0
 Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
 2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
 3. Ваши методы должны бросить исключения в случаях:
    Если размер матрицы, полученной из строки, не равен 4x4;
    Если в одной из ячеек полученной матрицы не число; (например символ или слово)
 4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.
 5. * Написать собственные классы исключений для каждого из случаев
     */
    public static String string = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 1 0";
    public static void main(String[] args) {
    try {
        System.out.println(superMethod(string));}
    catch (ShitException e){
        e.printStackTrace();
    }
    catch (ZinaException e){
        e.printStackTrace();
    }
    }
    public static int superMethod(String string) throws ShitException,  ZinaException {
        char ch = '\n';
        String ss="";
        int stroka = 0;
        int stolbec = 0;
        String[][] strings = new String[4][4];
        for(int i = 0; i < string.length(); i++){

            if(string.charAt(i)!=' '&&string.charAt(i)!=ch){
                if (string.charAt(i)!='0' & string.charAt(i)!='1' &
                        string.charAt(i)!='2'&string.charAt(i)!='3' &
                        string.charAt(i)!='4'&string.charAt(i)!='5' &
                        string.charAt(i)!='6'&string.charAt(i)!='7' &
                        string.charAt(i)!='8'&string.charAt(i)!='9'){
                    throw new ShitException("Символ в строке не является числом");
                }
                else {
                ss=ss + string.charAt(i);}
            }
            if(string.charAt(i)==' '){
                strings[stroka][stolbec] =ss;
                System.out.println(ss);
                ss="";
                stolbec++;
            }
            if(string.charAt(i)==ch){
                strings[stroka][stolbec] =ss;
                ss="";
                stolbec=0;
                stroka++;
            }
            if (i == string.length()-1)
                strings[stroka][stolbec] = ss;
        }

        int summa =0;
        for (String[] strin: strings){
            for (String str: strin){
                if (str==null){
                    throw new ZinaException("В ячейке массива null");
                }
                summa += Integer.parseInt(str);

            }
        }
        return summa/2;
    }


}
