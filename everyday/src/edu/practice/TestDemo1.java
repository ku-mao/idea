package edu.practice;

import java.util.concurrent.atomic.AtomicInteger;

public class TestDemo1 {
    //private static int num = 0;
    private static AtomicInteger num = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    //num++;
                    //num.getAndIncrement(); //i++
                    num.incrementAndGet(); //++i
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(num);
    }
}
