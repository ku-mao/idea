package src1;

import src1.Animal;

public class Bird extends Animal {
 //   public int age;
    public Bird(String name){
        super(name);
      //  this.age = age;
    }

    public void fly() {
        //this Brid类对象
        System.out.println(this.name +"正在飞");
        System.out.println(super.name);
        super.eat();
    }

    public void testProtected() {
        System.out.println(this.sex);
    }
}
