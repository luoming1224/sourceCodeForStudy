package threadstudy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    public static void main(String[] args) {
        final Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
//                LockSupport.park();
                LockSupport.park(this);
                if (Thread.interrupted()) {
                    System.out.println("thread " + Thread.currentThread().getId() + " is interrupted!!!");
                }
                System.out.println("thread " + Thread.currentThread().getId() + " awake!");
            }
        });
        t.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        t.interrupt();
        LockSupport.unpark(t);
    }
}
