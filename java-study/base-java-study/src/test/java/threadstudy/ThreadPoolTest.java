package threadstudy;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPoolTest {
    @Test
    public void test01() throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(2, new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build());
        final LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<String>();
        for(int i = 1; i <= 10; i ++) {
            deque.add(i + "");
        }
        es.submit(new Runnable() {
            @Override
            public void run() {
                while(!deque.isEmpty()) {
                    System.out.println(deque.poll() + "-" + Thread.currentThread().getName());
                }
            }
        });
        es.submit(new Runnable() {
            @Override
            public void run() {
                while(!deque.isEmpty()) {
                    System.out.println(deque.poll() + "-" + Thread.currentThread().getName());
                }
            }
        });

        Thread.sleep(4000l);
    }

    @Test
    public void test02() throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(2, new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build());
        final LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<String>();
        for(int i = 1; i <= 500; i ++) {
            deque.add(i + "");
        }
        Future<String> result = es.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                while (!deque.isEmpty()) {
                    System.out.println(deque.poll() + "-" + Thread.currentThread().getName());
                }
                return "done";
            }
        });
        System.out.println(result.isDone());
        // get方法会阻塞
//        System.out.println(result.get(5, TimeUnit.MILLISECONDS));
        try {
            // catch TimeoutException的话线程里的代码还是会执行下去
            System.out.println(result.get(3, TimeUnit.MILLISECONDS));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("exec next");
    }

    @Test
    public void test03() throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(2, new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build());
        final LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<String>();
        for(int i = 1; i <= 5000; i ++) {
            deque.add(i + "");
        }
        Future<String> result = es.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                while (!deque.isEmpty() && !Thread.currentThread().isInterrupted()) {
                    System.out.println(deque.poll() + "-" + Thread.currentThread().getName());
                }
                return "done";
            }
        });

        try {
            System.out.println(result.get(10, TimeUnit.MILLISECONDS));
        } catch (TimeoutException e) {
            System.out.println("cancel result: " + result.cancel(true));
            System.out.println("is cancelled: " + result.isCancelled());
        }
        Thread.sleep(2000l);
    }

    @Test
    public void test04() throws Exception {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3, new ThreadFactoryBuilder().setNameFormat("thread-schedule-runner-%d").build());
        /*Future<String> result = ses.schedule(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("exec task");
                return "ok";
            }
        }, 10, TimeUnit.SECONDS);

        System.out.println(result.get());*/

        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("fix task");
            }
        }, 0, 2, TimeUnit.SECONDS);

        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, 0, 2, TimeUnit.SECONDS);

        Thread.sleep(15000);
    }

    @Test
    public void test05() throws Exception {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2, new ThreadFactoryBuilder().setNameFormat("thread-schedule-runner-%d").build());
        Future<String> result = ses.schedule(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("exec task");
                try {
                    Thread.sleep(5000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("exec done, take 5 seconds");
                return "ok";
            }
        }, 10, TimeUnit.SECONDS);
        Thread.sleep(11000);
        result.cancel(true);
        Thread.sleep(10000);
    }






}
