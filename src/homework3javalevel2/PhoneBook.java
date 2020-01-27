package homework3javalevel2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    /*
    Написать простой класс PhoneBook(внутри использовать HashMap):
  - В качестве ключа использовать фамилию
  - В каждой записи всего два поля: phone, e-mail
  - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию,
  получили ArrayList телефонов), и отдельный метод для поиска e-mail по фамилии.
   Следует учесть, что под одной фамилией может быть несколько записей.
   Итого должно получиться 3 класса Main, PhoneBook, Person.
     */
    private Integer id;

    private HashMap<Integer, String> book;
    private HashMap<Integer, String[]> phonebook;

    public PhoneBook() {
        book = new HashMap<>();
        phonebook = new HashMap<>();
        this.id = 0;
    }
    public void add(String name, String email, String phone){
        this.book.put(id, name);
        this.phonebook.put(id, new String[]{email, phone});
        this.id++;
    }
    private ArrayList<String> get(String name,int i){
        ArrayList<String> array = new ArrayList<>();
        for(Map.Entry<Integer,String> pair : book.entrySet()){
            if(pair.getValue().equalsIgnoreCase(name)){
                array.add(phonebook.get(pair.getKey())[i]);
            }
        }
        return array;
    }
    public ArrayList<String>getEmail(String name){
        return this.get(name, 0);
    }
    public ArrayList<String>getPhone(String name){
        return this.get(name, 1);
    }



}
