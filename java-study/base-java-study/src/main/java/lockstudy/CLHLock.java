package lockstudy;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public class CLHLock {
    AtomicReference<QNode> tail = new AtomicReference<>(new QNode());
    ThreadLocal<QNode> myPred;
    ThreadLocal<QNode> myNode;

    public static class QNode {
        public volatile boolean locked = false;
    }

    public CLHLock() {
        myNode = new ThreadLocal<QNode>() {
            protected QNode initialValue() {
                return new QNode();
            }
        };
        myPred = ThreadLocal.withInitial(() -> null);
        /*myPred = new ThreadLocal<QNode>() {
            protected QNode initialValue() {
                return null;
            }
        };*/
    }

    public void lock() {
        QNode qNode = myNode.get();
        qNode.locked = true;
        QNode pred = tail.getAndSet(qNode);
        myPred.set(pred);
        while (pred.locked) {

        }
    }

    public void unlock() {
        QNode qNode = myNode.get();
        qNode.locked = false;
        myNode.set(myPred.get());
    }

    public static void main(String[] args) {
        final CLHLock lock = new CLHLock();
        lock.lock();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    System.out.println(Thread.currentThread().getId() + " acquired the lock!");
                    lock.unlock();
                }
            }).start();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }

        System.out.println("main thread unlock!");
        lock.unlock();
    }
}
