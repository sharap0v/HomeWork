package homework6;

public class main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        System.out.println(dog.run(100));
        Animal cat = new Cat();
        System.out.println(cat.swim(1000));
    }
}
