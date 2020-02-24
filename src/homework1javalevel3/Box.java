package homework1javalevel3;

import com.sun.source.tree.NewArrayTree;

import java.util.ArrayList;

public class Box<T extends Fruit> {
//   3. Большая задача:
//    a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//    b. Класс Box в который можно складывать фрукты, коробки условно
//    сортируются по типу фрукта, поэтому в одну коробку нельзя сложить
//    и яблоки, и апельсины;
//    c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//    d. Сделать метод getWeight() который высчитывает вес коробки,
//    зная количество фруктов и вес одного фрукта(вес яблока - 1.0f,
//    апельсина - 1.5f, не важно в каких это единицах);
//    e. Внутри класса коробка сделать метод compare, который позволяет
//    сравнить текущую коробку с той, которую подадут в compare в качестве параметра,
//    true - если их веса равны, false в противном случае(коробки с яблоками мы можем
//    сравнивать с коробками с апельсинами);
//    f. Написать метод, который позволяет пересыпать фрукты из текущей коробки
//    в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в
//    коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
//    а в другую перекидываются объекты, которые были в этой коробке;
//    g. Не забываем про метод добавления фрукта в коробку.
    private T obj;
    private ArrayList<T> box;

    public Box(T obj) {
        this.obj = obj;
        box = new ArrayList<T>();
    }


    public float getWeight(){
        return this.obj.getWeight1()*this.box.size();
    }
    public boolean compare(Box box){
        return this.getWeight() == box.getWeight();
    }
    public void addFruit(T fruit){
        this.box.add(fruit);
    }
    public T getTyp(){
        return this.obj;
    }
    public void sprinkle(Box box){
        if(this.obj.getClass() == box.getTyp().getClass()){
            for(T fruit: this.box){
                box.addFruit(fruit);
            }
        }
        else {
            System.out.println("Фрукты мешать нельзя");}
        //Ящики у нас резиновые
    }

}
