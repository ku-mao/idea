public class TestDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "小白";
        dog.eat();

        Bird bird = new Bird("小黑");
        bird.eat();
        bird.fly();
    }
}
