package homework6;

public class Cat extends Animal {
    public Cat(){
        this.run = random.nextInt(201);
        this.jump = (float) (random.nextInt(21)*0.1);
        this.swim = -1;
    }
}
