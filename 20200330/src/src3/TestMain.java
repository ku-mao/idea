package src3;


class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }
    public void eat() {
        System.out.println("Animal" + this.name + "正在吃！");
    }
}

class Bird extends  Animal {

    public Bird(String name) {
        super(name);
    }
}
class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }
}

public class TestMain {
    public static void main(String[] args) {
        //父类引用 引用了子类对象 -》向上转型
        Animal animal = new Bird("小黑");
        animal.eat();

    }


    public static void main1(String[] args) {
        Animal animal = new Animal("小白");

        Bird bird = new Bird("小黑");

        Cat cat = new Cat("小花");

    }
}
