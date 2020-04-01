package src3;


class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
        eat();
    }
    public void eat() {
        System.out.println("Animal" + this.name + "正在吃！");
    }
}

class Bird extends  Animal {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("Bird" + this.name + "正在吃米！");
    }
    
    public void fly() {
        System.out.println(this.name + "正在飞");
    }
}
class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }
}

public class TestMain {
    //构造函数当中是否可以发生动态绑定  -- 可以
    public static void main(String[] args) {
        Animal animal = new Animal("小白1");
        System.out.println();
        Animal bird = new Bird("小白2");
    }

    //错误示例
    public static void main4(String[] args) {
        Animal animal = new Cat("咪咪");
        //animal 并不是 Bird 的一个实例
        if (animal instanceof Bird) {
            Bird bird = (Bird) animal;
            bird.fly();
        }
    }

    public static void main3(String[] args) {
        Animal animal = new Bird("小白");
        animal.eat();

        Bird bird =(Bird) animal;//向下转型
        bird.fly();
    }


    public static void main2(String[] args) {
        //父类引用 引用了子类对象 -》向上转型
        Animal animal = new Bird("小黑");
        animal.eat();
        //animal.fly();//编译不通过，通过父类引用只能引用父类自己的方法


    }


    public static void main1(String[] args) {
        Animal animal = new Animal("小白");

        Bird bird = new Bird("小黑");

        Cat cat = new Cat("小花");

    }
}
