package Thread;

public class ThreadDemo20 {
    static class BlockingQueue {
        //普通的队列实现
        //基于链表
        //基于数组(使用这个方式)
        private int[] array = new int[1000];
        private volatile int head = 0;
        private volatile int tail = 0;
        //head和tail构成一个前闭后开区间
        //当两者重合时,可能是表示队列空,也可能是表示队列满
        //为了区分空还是满,就需要额外引入一个size表示
        private volatile int size = 0;

        //队列的基本操作
        //1.入队列
        //2.出队列
        //3.取队首元素

        //针对阻塞队列来说,只提供前两个操作
        //阻塞版本的入队列,为了和之前的版本区别,用了不同非名字
        public void put(int value) throws InterruptedException {
            synchronized (this) {
                while (size == array.length) {
                    wait();
                }
                array[tail] = value;
                tail++;
                if (tail == array.length) {
                    tail = 0;
                }
                size++;
                notify();
            }

        }

        //阻塞版本的出队列,用了不同的名字
        public int take() throws InterruptedException {
            int ret = -1;
            synchronized (this) {
                while (size == 0) {
                    wait();
                }
                ret = array[head];
                head++;
                if (head == array.length) {
                    head = 0;
                }
                size--;
                notify();
            }
            return ret;
        }

        public static void main(String[] args) {
            BlockingQueue blockingQueue = new BlockingQueue();
            Thread producer = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        for (int i = 0; i < 10000; i++) {
                            try {
                                blockingQueue.put(i);
                                System.out.println("生产者生产:" + i);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
            };
            producer.start();

            Thread consumer = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        int ret = 0;
                        try {
                            ret = blockingQueue.take();
                            System.out.println("消费元素:" + ret);
                            sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            consumer.start();
        }



















    }
}
