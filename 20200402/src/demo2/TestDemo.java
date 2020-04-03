package demo2;

class Shape {
    public void draw() {

    }
}

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
    //类的调用者
    public static void drawMap(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        Shape[] shapes = {new Cycle(),new Rect(),new Flower(), new Triangle()};
        for (Shape shape : shapes ){
            shape.draw();
        }
    }


    //采用太多的if-else
    public static void main2(String[] args) {
        Rect rect = new Rect();
        Cycle cycle = new Cycle();
        Flower flower = new Flower();
        String[] shapes = {"cycle", "rect", "flower"};
        for (String shape : shapes) {
            if (shape.equals("cycle")) {
                cycle.draw();
            } else if (shape.equals("rect")) {
                rect.draw();
            } else if (shape.equals("flower")) {
                flower.draw();
            }
        }
    }
    public static void main1(String[] args) {
        Shape shape1 = new Cycle();
        //shape1.draw();

        Shape shape2 = new Rect();
        //shape2.draw();

        drawMap(shape1);
        drawMap(shape2);

        Shape shape3 = new Flower();
        drawMap(shape3);

        Flower flower = new Flower();
        drawMap(flower);

    }
}
