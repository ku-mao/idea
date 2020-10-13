package edu.practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestDemo2 {
    //创建一个线程进行求和
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable <Integer>() {
            @Override
            public Integer call() throws Exception {
                int ret = 0;
                for (int i = 1; i <= 5000; i++) {
                    ret += i;
                }
                return ret;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask <>(callable);
        Thread t = new Thread(futureTask);
        t.start();

        Integer result = futureTask.get(); //get方法是阻塞的, 直到线程结束, 才会返回
        System.out.println(result);
    }
}
