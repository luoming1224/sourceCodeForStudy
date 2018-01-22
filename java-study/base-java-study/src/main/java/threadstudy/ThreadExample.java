package threadstudy;

import java.util.concurrent.TimeUnit;

public class ThreadExample {
    public static void main(String[] args) {
        System.out.println("主线程id:" + Thread.currentThread().getId());
        TestRunnable1 testRunnable1 = new TestRunnable1();
        Thread thread1 = new Thread(testRunnable1);
        System.out.println("线程优先级:" + thread1.getPriority());
        thread1.start();


        Thread thread = new Thread(() -> {
            System.out.println("hello thread!");
            try {
                TimeUnit.SECONDS.sleep(5);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.isInterrupted();
        try {
            thread.join();
            System.out.println("hello world!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class TestRunnable1 implements Runnable {
    @Override
    public void run() {
        System.out.println("子线程id:" + Thread.currentThread().getId());
    }
}
