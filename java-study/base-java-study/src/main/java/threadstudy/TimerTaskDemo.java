package threadstudy;

import java.util.Timer;

public class TimerTaskDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTaskTest(), 1000, 2000);
    }

}
