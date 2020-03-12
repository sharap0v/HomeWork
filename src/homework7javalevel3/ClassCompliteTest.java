package homework7javalevel3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;

public class ClassCompliteTest {
    /*
 Создать класс, который может выполнять «тесты», в качестве тестов
  выступают классы с наборами методов с аннотациями @Test. Для этого
   у него должен быть статический метод start(), которому в качестве
   параметра передается или объект типа Class, или имя класса.
    Из «класса-теста» вначале должен быть запущен метод с аннотацией
    @BeforeSuite, если такой имеется, далее запущены методы с аннотациями
    @Test, а по завершению всех тестов – метод с аннотацией @AfterSuite.
     К каждому тесту необходимо также добавить приоритеты (int числа от 1 до 10),
     в соответствии с которыми будет выбираться порядок их выполнения,
     если приоритет одинаковый, то порядок не имеет значения.
     Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать
     в единственном экземпляре, иначе необходимо бросить RuntimeException
     при запуске «тестирования».
 */
    public static void start(Class clas) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object object = clas.newInstance();
        Method[] methods = clas.getDeclaredMethods();
        if(dontuse(clas,methods)){
            throw new RuntimeException();
        }
        Method before = null;
        Method after=null;
        ArrayList<Method> Tests = new ArrayList<>();
        for(Method method: methods){
        if(method.getAnnotation(BeforeSuite.class)!=null){
            before = method;
        }
        if(method.getAnnotation(AfterSuite.class)!=null){
            after = method;
        }
        if (method.getAnnotation(Test.class)!=null){
            Tests.add(method);
        }
        }
        Tests.sort(Comparator.comparingInt(t->t.getAnnotation(Test.class).priority()));
        if(before!=null)
        before.invoke(object);
        for(Method method: Tests){
            if (Modifier.isPrivate(method.getModifiers())){
                method.setAccessible(true);
            }
            method.invoke(object);
        }

        if (after!=null)
        after.invoke(object);
    }
    private static boolean dontuse(Class clas, Method[] methods){
        int a=0;
        int b = 0;
        for (Method method: methods){
            if(method.getAnnotation(BeforeSuite.class)!=null){
                a++;
            }
            if(method.getAnnotation(AfterSuite.class)!=null){
                b++;
            }
        }
        return (b>1)&&(a>1);
    }
}
