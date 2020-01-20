package homework6;


public class Dog extends Animal{

            //5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.*/
    public Dog(){
        this.run = random.nextInt(501);
        this.jump = (float) (random.nextInt(5)*0.1);
        this.swim = random.nextInt(10);

    }

}
