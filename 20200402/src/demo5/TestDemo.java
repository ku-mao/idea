package demo5;

class Animal {
    protected String name;
    public Animal(String name) {
        this.name = name;
    }
}
interface IFlying {
    void fly();
}
interface IRunning {
    void run();
}
interface ISwimming {
    void swim();
}

class Cat extends Animal implements IRunning {
    public Cat(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(this.name + "正在用四条腿跑");
    }
}

class Frog extends Animal implements IRunning, ISwimming {
    public Frog(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(this.name + "正在往前跳");
    }
    @Override
    public void swim() {
        System.out.println(this.name + "正在蹬腿游泳");
    }
}

class Robot implements IRunning {

    @Override
    public void run() {
        System.out.println("机器人会跑");
    }
}
public class TestDemo {
    public static void walk(IRunning iRunning) {
        iRunning.run();
    }

    public static  void swim (ISwimming iSwimming) {
        iSwimming.swim();
    }
    public static void main(String[] args) {
        Cat cat = new Cat("小花");
        walk(cat);
        Frog frog = new Frog("小哇");
        walk(frog);
        swim(frog);
        Robot robot = new Robot();
        walk(robot);
    }
}
