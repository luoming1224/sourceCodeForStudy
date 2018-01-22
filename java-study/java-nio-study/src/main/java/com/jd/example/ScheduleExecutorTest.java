package com.jd.example;

import java.util.concurrent.*;

public class ScheduleExecutorTest {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        ScheduledFuture<?> future = executorService.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("60 seconds later");
                    }
                }, 5,10, TimeUnit.SECONDS
        );

        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
