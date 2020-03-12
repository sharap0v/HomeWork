package homework7javalevel3;





public class ClassRunTest {
@Test(priority = 2)
    public static void Test1(){
        System.out.println("test1");
    }
    @Test(priority = 3)
    public static void Test2(){
        System.out.println("test1");
    }@Test(priority = 4)
    public static void Test3(){
        System.out.println("test1");
    }@Test(priority = 5)
    public static void Test4(){
        System.out.println("test1");
    }@Test(priority = 6)
    public static void Test5(){
        System.out.println("test1");
    }@Test(priority = 7)
    public static void Test6(){
        System.out.println("test1");
    }@Test(priority = 8)
    public static void Test7(){
        System.out.println("test1");
    }@Test(priority = 9)
    public static void Test8(){
        System.out.println("test1");
    }@Test(priority = 1)
    public static void Test9(){
        System.out.println("test1");
    }@BeforeSuite
    public static void BeforeSuite(){
        System.out.println("BeforeSuite");
    }@AfterSuite
    public static void AfterSuite(){
        System.out.println("AfterSuite");
    }

}
