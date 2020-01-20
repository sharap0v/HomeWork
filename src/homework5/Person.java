package homework5;

import java.util.Currency;

public class Person {
    /*1.Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    2.Конструктор класса должен заполнять эти поля при создании объекта.
    3.Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    */
    private String name;
    private String position;
    private String email;
    private String telephoneNumber;
    private double salary;
    private int age;

    public Person(String name,String position, String email,String telephoneNumber, double salary,int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.salary =salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void info(){
        System.out.println(this.name + " " +
        this.position + " "+
        this.email + " " +
        this.telephoneNumber + " " +
        this.salary + " " +
        this.age);
    }
}
