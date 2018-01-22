package threadstudy;

public class Test {
    public static void main(String[] args)  {
        System.out.println("主线程ID："+Thread.currentThread().getId());
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
class MyRunnable implements Runnable{
    public MyRunnable() {
    }

    @Override
    public void run() {
        System.out.println("子线程ID："+Thread.currentThread().getId());
    }
}