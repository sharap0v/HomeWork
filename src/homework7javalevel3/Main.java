package homework7javalevel3;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clas = "ClassRunTest".getClass();
        ClassCompliteTest.start(clas);
    }
}
