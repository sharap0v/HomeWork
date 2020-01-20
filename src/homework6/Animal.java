package homework6;
import java.util.Random;


public abstract class Animal {
    /* 1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true)
5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
*/
    Random random = new Random();
    int run;
    float jump;
    int swim;
    public boolean run(int distance){
        if(distance>run)
        {return false;}
        else {return true;}
    }
    public boolean jump(float height){
        if(height>jump)
        {return false;}
        else {return true;}
    }
    public boolean swim(int distance){
        if(distance>swim)
        {return false;}
        else {return true;}
    }


}
