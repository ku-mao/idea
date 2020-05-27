package edu;

class Cat{
    private String name;

    public void eat(String food) {
        System.out.println(name + "正在吃" + food);
    }

    public Cat(String name) {
        this.name = name;
    }
}
public class TestReflect  {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取类对象
        //第一种获取方式是最灵活的,写代码的时候不需要知道类名,在实际运行时再获取类名
        //第二种和第三种方式都是需要在写代码的时候就知道类名
        //直接通过全限定类名获取
        Class catClass = Class.forName("edu.Cat");

        //通过类的实例来获取
        Cat cat = new Cat("咪咪");
        Class catClass2 = cat.getClass();

        //通过类直接来获取
        Class catClass3 = Cat.class;
        System.out.println(catClass == catClass2);
        System.out.println(catClass2 == catClass3);
    }

}
