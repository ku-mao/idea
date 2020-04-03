package demo3;

/**
 * 抽象类：包含抽象方法的类
 * 1.用关键字abstract进行修饰
 * 2.在抽象类中，可以有普通类的所有属性
 * 3.和普通的类 不一样的地方就是，包含了抽象方法
 * 4、和普通的类 不一样的地方就是，不能够被实例化
 * 5.抽象类的主要作用就是用来被继承的
 * 6.抽象类的主要作用就是用来被继承的，所以不能被final修饰
 * 7.抽象方法 也不能是私有的 或者是static
 * 8.只要有一个类，继承了这个抽象类 那么必须重写抽象类当中的方法
 * 9.如果这个类，不想重写抽象类的方法，可以用abstract修饰
 *
 */
abstract class Shape {
    public abstract void draw() ;//抽象方法不可以实现
}

 abstract class A extends Shape {

}
//class B extends  A {
// 这里必须重写
//}

class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("这是一个圆！");
    }
}

class Rect extends Shape {

    @Override
    public void draw() {
        System.out.println("这是一个矩形！");
    }
}

    class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("这是一朵❀");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("这是一个三角形");
    }
}
public class TestDemo {

    public static void drawMap(Shape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        //也可以向上转型
        Shape shape1 = new Cycle();
        Shape shape2 = new Rect();
        Shape shape3 = new Flower();

        drawMap(shape1);
        drawMap(shape2);
        drawMap(shape3);
    }

}
