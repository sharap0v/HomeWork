


public class homework1 {
    int a = 2147483647; //2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
    float b =3.4e+38f;
    double g = 1.7e+308;
    char c = 22;
    boolean p = true;
    byte d = 127;
    short e = 32767;
    long f = 9223372036854775807L;
    String string = "Как же так";
    public static void main(String[] args) { //1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
        System.out.println( method(1,2,3,4));
        System.out.println(check(2, 10));
        positiveOrnegative(3);
        System.out.println(negative(3));
        returnHelloName("Олег");
        lofty(2020);
        lofty(2019);
    }

    public static double method(double a, double b,double c, double d){
            /*3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    где a, b, c, d – входные параметры этого метода;
    */
        return a * (b + (c / d));
    }
    public static boolean check(int a, int b){
        /*4. Написать метод, принимающий на вход два числа,
        и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
         если да – вернуть true, в противном случае – false;
         */
        if (a+b>=10&&a+b<=20){
            return true;
        }
        else return false;
    }
    public static void positiveOrnegative(long a){
        /*5. Написать метод, которому в качестве параметра
         передается целое число, метод должен напечатать в
         консоль положительное ли число передали, или отрицательное;
         Замечание: ноль считаем положительным числом.
         */
        if (a>=0){
            System.out.println("Число " + a + " положительное!");
        }
        else System.out.println("Число " + a + " отрицательное!");
    }
    public static String negative(int a){
        /*6. Написать метод, которому в качестве параметра
        передается целое число, метод должен вернуть true, если число отрицательное;
         */
        // тип возвращаемого значения выбран стринг специально! так как в случае если число положительное, чтобы не пришлось вернуть"false"!
        if(a<0){
            return "true";
        }
        else return "" ;
    }
    public static void returnHelloName(String name){
        /*7. Написать метод, которому в качестве параметра передается строка,
         обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
         */
        System.out.println("Привет, " + name +"!");
    }
    public static void lofty(int year){
        /*
        8. * Написать метод, который определяет является ли год високосным,
         и выводит сообщение в консоль. Каждый 4-й год является високосным,
          кроме каждого 100-го, при этом каждый 400-й – високосный.
         */
        if (((year % 100 == 0) && (year % 400 != 0))||(year % 4 != 0))
        {
            System.out.println(year + " год НЕ является високосным!");
        }
        else System.out.println(year + " год является високосным!");
    }

}
