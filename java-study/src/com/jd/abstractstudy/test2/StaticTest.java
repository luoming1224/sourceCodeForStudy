package com.jd.abstractstudy.test2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class StaticTest {
    private static final AtomicInteger nextId = new AtomicInteger();


    public static void main(String[] args) {
    /*    System.out.println(nextId);
        nextId.getAndIncrement();
        System.out.println(nextId);
        nextId.getAndIncrement();
        System.out.println(nextId);*/

        Date now = new Date();
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        SimpleDateFormat sdfWeek = new SimpleDateFormat("EEEE");
        String nowTime = sdfTime.format(now);
        String nowWeek = sdfWeek.format(now);

        String[] times = nowTime.split(" ");
        String date = times[0];
        String time = times[1];

        Calendar calendar = Calendar.getInstance();
//        now.setTime(1512561120);
        calendar.setTime(now);
        int w = calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println(now);
        System.out.println(nowTime);
        System.out.println(nowWeek);

        System.out.println(date);
        System.out.println(time);

        System.out.println(w);

    }
}
