package lockstudy;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {

        test02();
    }

    public static void test01() {
        DataOutput dataOutput = new DataOutput();

        MyThread thread0 = new MyThread(dataOutput);
        MyThread thread1 = new MyThread(dataOutput);
        MyThread thread2 = new MyThread(dataOutput);

        thread0.start();
        thread1.start();
        thread2.start();
    }

    public static void test02() {
        ConditionModule cm = new ConditionModule();
        MyThread2 thread2 = new MyThread2(cm);
        thread2.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cm.signalMethod();
    }
}

class MyThread extends Thread {
    private final DataOutput dataOutput;

    public MyThread(DataOutput dataOutput) {
        this.dataOutput = dataOutput;
    }

    @Override
    public void run() {
        dataOutput.write();
    }
}

class DataOutput {
    private final Lock lock = new ReentrantLock();

    public void write() {
        try {
            lock.lock();
            int n = (new Random()).nextInt(5) + 1;
            for (int i = 0; i < n; ++i) {
                System.out.println("ThreadID " + Thread.currentThread().getId() + ": i = " + i);
            }
            System.out.println("==========================");
        } finally {
            lock.unlock();
        }
    }
}

class ConditionModule {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void awaitMethod() {
        try {
            lock.lock();
            System.out.println("await  time: " + System.currentTimeMillis());
            condition.await();
            System.out.println("await end!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalMethod() {
        try {
            lock.lock();
            System.out.println("signal time: " + System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}

class MyThread2 extends Thread {
    private final ConditionModule conditionModule;

    public MyThread2(ConditionModule cm) {
        this.conditionModule = cm;
    }
    @Override
    public void run() {
        conditionModule.awaitMethod();
    }
}
