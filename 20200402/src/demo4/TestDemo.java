package demo4;

/*abstract  class Shape {
    public abstract void draw();
}*/


/**
 * 接口注意事项
 * interface 关键字修饰
 * 1.里面的数据成员必须是一个常量
 * 默认是public static final 修饰
 * 方法默认是public abstract 修饰
 * 2.接口当中 不能够定义一个已经实现的方法
 * 3.JDK1.8 新特性：接口当中可以有实现的方法，但这个方法一定要被default修饰
 * 4.类和接口的关系：实现-》implemens 可以实现多个接口，解决了Java当中的单继承问题
 * 5.实现了该接口，一定要重写该接口当中的方法
 * 6.接口不可以被实例化 但是可以发生向上转型
 * 7.实现接口中的方法时，不能省略public
 */
interface IShape {

    void draw();
    //default void func() { }
    //int a = 10;
}

class Cycle implements IShape {
    @Override
    public void draw() {
        System.out.println("这是一个圆！");
    }
}


class Rect implements IShape {

    @Override
    public void draw() {
        System.out.println("这是一个矩形！");
    }
}

class Flower implements IShape {
    @Override
    public void draw() {
        System.out.println("这是一朵❀");
    }
}

class Triangle implements IShape {
    @Override
    public void draw() {
        System.out.println("这是一个三角形");
    }
}
public class TestDemo {
    public static void drawMap(IShape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        IShape shape1 = new Cycle();
        IShape shape2 = new Rect();
        IShape shape3 = new Flower();
        drawMap(shape1);
        drawMap(shape2);
        drawMap(shape3);
    }
}
