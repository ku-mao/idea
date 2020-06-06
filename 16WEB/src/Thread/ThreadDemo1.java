package Thread;


public class ThreadDemo1 {
    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("hello world ,我是一个线程");
        }
    }

    public static void main(String[] args) {
        //创建线程需要用到Thread 类,来创建一个Thread的实例
        //另一方面需要给这个线程指定,需要执行那些指令代码
        //
        Thread t = new MyThread();
        t.start();
    }

}
