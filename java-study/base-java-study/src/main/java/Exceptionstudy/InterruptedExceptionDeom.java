package Exceptionstudy;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InterruptedExceptionDeom {

    public static void main(String[] args) {
//        testCatch();
        test02();
//        test03();
    }

    public static void testCatch() {
        Thread thread = new Thread( new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("after interruptedException");
                for (int i = 0; i < (new Random().nextInt(10)); ++i) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        });
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    public static void test02() {
        Thread thread = new Thread(new Runnable() {
            private double d = 0.0;
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("I am running!");

                        for (int i = 0; i < 900000; i++) {
                            d =  d + (Math.PI + Math.E) / d;
                        }
                        //休眠一断时间,中断时会抛出InterruptedException
                        Thread.sleep(50);
                    }
                } catch (InterruptedException e) {
                    System.out.println("ATask.run() interrupted!");
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();

        //运行一断时间中断线程
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
        System.out.println("****************************");
        System.out.println("Interrupted Thread!");
        System.out.println("****************************");
        thread.interrupt();


    }

    public static void test03() {
        Thread thread = new Thread(new Runnable() {
            private double d = 0.0;
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    System.out.println("I am running!");

                    for (int i = 0; i < 900000; i++) {
                        d =  d + (Math.PI + Math.E) / d;
                    }
                }
                System.out.println("ATask.run() interrupted!");
            }
        });
        thread.start();

        //运行一断时间中断线程
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
        System.out.println("****************************");
        System.out.println("Interrupted Thread!");
        System.out.println("****************************");
        thread.interrupt();
    }



}


