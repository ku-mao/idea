package Thread;

public class ThreadDemo7 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("我正在转账!!!");
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("转账被终止!");
            }
        };
        t.start();

        Thread.sleep(5000);
        //有内鬼,需要终止交易
        System.out.println("有内鬼,终止交易!");
        t.interrupt();
    }
}
