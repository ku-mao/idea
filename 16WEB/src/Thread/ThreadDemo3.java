package Thread;

public class ThreadDemo3 {
    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("我是一个新线程");
        }
    }
    public static void main(String[] args) {
        //1.显式继承Thread
        //2.通过匿名内部类的方式继承Thread
//        Thread t = new Thread() {
//                    @Override
//                    public void run() {
//
//                    }
//                };
//                t.start();
        //3.显式创建一个类,实现Runnable接口,然后把这个Runnable的实例关联到Thread实例上
//        Thread t = new Thread(new MyRunnable());
//        t.start();

        //4.通过匿名内部类的方法来实现Runnable接口
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("我是一个新线程");
//            }
//        };
//        Thread t = new Thread(runnable);
//        t.start();
        //5.通过lambda表达式来指定执行的内容
        Thread t = new Thread(() -> {
            System.out.println("我是一个新线程");
        });
        t.start();
    }
}
