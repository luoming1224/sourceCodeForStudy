package lockstudy;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        System.out.println("readWriteLock.readLock().lock() begin");
        readWriteLock.readLock().lock();
        System.out.println("readWriteLock.readLock().lock() over");


        new Thread(){
            @Override
            public void run() {
                for(int i = 0; i< 2; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(" ");
                    System.out.println("Thread readWriteLock.readLock().lock() begin i:"+i);
                    readWriteLock.readLock().lock(); // 获取过一次就能再次获取, 但是若其他没有获取的线程因为 syn queue里面 head.next 是获取write的线程, 则到 syn queue 里面进行等待
                    System.out.println("Thread readWriteLock.readLock().lock() over i:" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }.start();

 /*       try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        System.out.println("readWriteLock.writeLock().lock() begin");
        readWriteLock.writeLock().lock();
        System.out.println("readWriteLock.writeLock().lock() over");

    }

}
