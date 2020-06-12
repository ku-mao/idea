package Thread;

public class ThreadDemo4{
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("我是一个线程!");
            }
        };
        //t.run();
        t.start();
    }

}
