package Thread;

import java.util.concurrent.PriorityBlockingQueue;

public class ThreadDemo21 {
    //要往优先阻塞队列中放元素,必须是可以比较的
    //所以要实现比较规则
    //1.实现comparable 接口
    //2.在优先级队列中传入一个比较器comparator
    static class Task implements Comparable<Task> {
        //Runnable 中有一个run方法,可以借助run方法来实现具体的任务是啥
        private Runnable command;
        //time 表示啥时候来执行 command ,是一个绝对的时间
        private long time;

        public Task(Runnable command, long after) {
            this.command = command;
            this.time = System.currentTimeMillis() + after;
        }
        public void  run() {
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            //谁的优先级小,谁先执行
            return (int) (this.time - o.time);
        }
    }

    static class Worker extends Thread {
        private Object mailBox = null;
        private PriorityBlockingQueue<Task>  queue = null;
        public Worker(PriorityBlockingQueue<Task> queue, Object mailBox) {
            this.queue = queue;
            this.mailBox = mailBox;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    //判断当前时间到了没
                    Task task = queue.take();
                    if (task.time > System.currentTimeMillis()) {
                        //时间没到,把他又塞回去
                        queue.put(task);
                        synchronized (mailBox) {
                            mailBox.wait(task.time -System.currentTimeMillis());
                        }
                    } else  {
                        //时间到了,执行该进行的任务
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
    static class Timer {
        //1.使用一个Task类来描述"一段逻辑" (一个要执行的任务) ,同时也要记录这个任务在啥时候来执行.
        //2.使用一个阻塞优先队列来组织若干个Task.
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue <>();
        Object mailBox = new Object();
        //3.还需要一个扫描线程,扫描线程要循环的检测
        //队首元素是否需要执行.如果需要执行的话,
        //就执行这个任务.

        public Timer () {
            //创建线程
            Worker worker = new Worker(queue,mailBox);
            worker.start();
        }
        //4.还需要提供一个方法,让调用者把任务安排进来
        public void schedule(Runnable command, long after) {
            Task task = new Task(command, after);
            queue.put(task);
            synchronized (mailBox) {
                mailBox.notify();
            }
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hehe");
                timer.schedule(this, 2000);
            }
        }, 2000);
    }
}