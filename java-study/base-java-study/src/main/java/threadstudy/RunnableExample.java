package threadstudy;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableExample {

    static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        futureDemo();
    }

    static void futureDemo() {
        try {
            Future<?> result1 = executor.submit(new Runnable() {
                @Override
                public void run() {
                    fibc(20);
                }
            });
            System.out.println("future result from runnable: " + result1.get());

            final Integer resultFibc =100;
            Future<Integer> result2 = executor.submit(new Runnable() {
                @Override
                public void run() {
                    fibc(20);
                }
            }, resultFibc);
            System.out.println("future result from runnable: " + result2.get());

            Future<?> result = executor.submit(() -> fibc(20));
            System.out.println("future result from callable: " + result.get());




        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int fibc(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return fibc(num - 1) + fibc(num - 2);
    }

}
