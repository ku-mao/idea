package src1;



public class TestDemo {

    public static void main(String[] args) {
        Animal a = new Animal("小红");
        System.out.println(a.sex);
    }


    public static void main1(String[] args) {
        Dog dog = new Dog("小白");
        dog.eat();

        Bird bird = new Bird("小黑");
        bird.eat();
        bird.fly();
    }
}
