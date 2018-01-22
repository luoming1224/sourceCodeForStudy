package collectionstudy;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        test02();

    }

    private static void test02() {
        final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();

        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread start");
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                }
                System.out.println("put thread end");
            }
        });

        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread start");
                try {
                    System.out.println("take from putThread: " + queue.take());
                } catch (InterruptedException e) {
                }
                System.out.println("take thread end");
            }
        });

        putThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        takeThread.start();
    }

    private static void test01() {
        SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();
        Producer p1 = new Producer("p1", queue, 10);
        Producer p2 = new Producer("p2", queue, 50);

        Consumer c1 = new Consumer("c1", queue);
        Consumer c2 = new Consumer("c2", queue);


        c1.start();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p1.start();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        c2.start();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p2.start();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 如果把下面两个线程操作中的offer/poll改为put/take，则无论main函数中按怎样的顺序启动线程，都可以正确发送和获取
     */

    static class Producer extends Thread {
        private SynchronousQueue<Integer> queue;
        private int n;
        public Producer(String name, SynchronousQueue<Integer> queue, int n) {
            super(name);
            this.queue = queue;
            this.n = n;
        }

        public void run() {
            System.out.println(getName() + " offer result " + queue.offer(n));
            /*try {
                System.out.println(getName() + " put " + n);
                queue.put(n);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }

    static class Consumer extends Thread {
        private SynchronousQueue<Integer> queue;
        public Consumer(String name, SynchronousQueue<Integer> queue) {
            super(name);
            this.queue = queue;
        }

        public void run() {
//            System.out.println(getName() + " take result " + queue.poll()); //如果这样调用，poll没有等待，会返回Null，生产者发送数据时会没有消费者，也会offer失败
            try {
//                System.out.println(getName() + " take result " + queue.take());
                System.out.println(getName() + " take result " + queue.poll(1, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void test03() {
        final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();
        new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("size1:" + queue.size());
                        System.out.println("element:" + queue.take());
                        System.out.println("size2:" + queue.size());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        try {
            queue.put(1);
            queue.put(2);
            queue.put(3);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
