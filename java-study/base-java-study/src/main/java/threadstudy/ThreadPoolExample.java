package threadstudy;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 20, 10, TimeUnit.SECONDS,new LinkedBlockingQueue(10));

        for(int i = 0; i < 15; i ++) {
            threadPoolExecutor.submit(new MyThread(i + 1));
        }
    }

    static class MyThread implements Runnable {
        private int index;
        public MyThread(int index) {
            this.index = index;
        }
        @Override
        public void run() {
            System.out.println(this.index);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }


}
