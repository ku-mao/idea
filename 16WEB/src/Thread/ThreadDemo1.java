package Thread;


public class ThreadDemo1 {
    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("hello world ,我是一个线程");
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        //创建线程需要用到Thread 类,来创建一个Thread的实例
        //另一方面需要给这个线程指定,需要执行那些指令代码
        //指定指令的方式有很多种,此处先用一种简单的,直接继承Thread类
        //重写Thread类的run方法.

        //当Thread 对象被创建出来的时候,内核中并没有随之产生一个线程(PCB)
        Thread t = new MyThread();
        //执行这个start方法,才真的创建出了一个线程
        //此时内核中才随之出现了一个PCB,这个PCB就会对应让cpu来执行该线程的代码(也就是上面的run方法)
        t.start();
        while (true){

        }
    }

}
