package edu.demo1;


/**
 * Cloneable 为什么是一个空接口
 * 标志接口  如果一个类实现了Cloneable 接口 代表这个类可以被克隆
 */

class Money implements Cloneable{
    public  int money = 19;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public int age;
    public Money m;
    public  Person (int age) {
        this.age = age;
        m = new Money();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person1 = (Person) super.clone();
        person1.m = (Money) this.m.clone();
        return person1;
    }
}

public class TestDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(10);

        Person person1 = (Person) person.clone();
        System.out.println(person.m.money);
        System.out.println(person1.m.money);

        System.out.println("**************");
        person1.m.money = 999;
        System.out.println(person.m.money);
        System.out.println(person1.m.money);
    }




    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person(10);

        Person person1 = (Person) person.clone();
        System.out.println(person.age);
        System.out.println(person1.age);
        System.out.println("*********");

        person1.age = 888;
        System.out.println(person.age);
        System.out.println(person1.age);

    }
}
