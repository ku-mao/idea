package src2;

import src1.Animal;
class Person {
   public Money money  ;
}

class Money {

}
public class Test extends Animal {
    public Test(String name) {
        super(name);
    }

    public void func() {
        System.out.println(super.name);
       // System.out.println(super.count);//不可以,默认属性不可在不同包中访问
    }

    public static void main(String[] args) {
        Animal animal = new Animal("小黄");
        //System.out.println(super.sex);
    }
}
