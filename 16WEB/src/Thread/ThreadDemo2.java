package Thread;

public class ThreadDemo2 {
    private static long count = 100_0000_0000L;
    public static void main(String[] args) {
        //serial();
        concurrency();
    }

    private static void concurrency() {
        long start = System.currentTimeMillis();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a++;
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                int b = 0;
                for (long i = 0; i < count; i++) {
                    b++;
                }
            }
        };
        t1.start();
        t2.start();
        //t1 和 t2 和 main线程之间是并发执行的
        //调用了t1.start 和 t2.start 之后两个新线程正在进行计算的过程中
        //此时主线程仍然会继续执行,下面的end 就随机被计算了
        //正确的做法是等t1 和 t2 都计算完之后,再计算end的时间戳

        try {
            //让主线程等待t1和t2 执行完之后再往下执行
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start) + "ms");
    }

    private static void serial() {//串行
        long start = System.currentTimeMillis();//获得毫秒级的时间戳
        int a = 0;
        for (long i = 0; i < count; i++) {
            a++;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b++;
        }
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start) + "ms");
    }
}
