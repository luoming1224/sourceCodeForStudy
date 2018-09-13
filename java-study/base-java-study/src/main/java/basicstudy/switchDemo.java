package basicstudy;

import java.util.Calendar;
import java.util.Date;

public class switchDemo {
    public static void main(String[] args) {
    /*    String a = "aaa";
        String b = "aaa";
        String c = new String("aaa");
        String d = new String("aaa");
        System.out.println("a==b:"+(a == b));  //true
        System.out.println("a==c:"+(a == c));  //false
        System.out.println("c==d:"+(c == d));  //false
        System.out.println("a与b的值相等:"+(a.equals(c)));  //true

        System.out.println("c.intern()==d.intern():" + ( c.intern() == d.intern() )); // true*/


//        5.判断定义为String类型的s1和s2是否相等
        /*String s1 = "ab";
        String s2 = "abc";
        String s3 = s1 + "c";
        System.out.println(s3 == s2);
        System.out.println(s3.equals(s2));
*/



       /* String str = "a";
        switch (str) {
            case "a":
                System.out.println("hello a!");
                break;
        }*/
        /*String mode = "ACTIVE";
        switch (mode) {
            case "ACTIVE":
                System.out.println("Application is running on Active mode");
                break;
            case "PASSIVE":
                System.out.println("Application is running on Passive mode");
                break;
            case "SAFE":
                System.out.println("Application is running on Safe mode");
        }*/


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));


        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        calendar.add(Calendar.HOUR, 24 * (-1));

        System.out.println(calendar.getTime());

        long time = calendar.getTimeInMillis() / 1000;
        System.out.println(time);
        time = timeRound(time, "day");

        System.out.println(time);
    }

    private static long timeRound(long time , String timeType ) {
        long timeSection;
        switch (timeType) {
            case "minute" :
                timeSection = 60;
                break;
            case "hour" :
                timeSection = 60 * 60;
                break;
            case "day":
                timeSection = 60 * 60 * 24;
                time = time + 60 * 60 * 8;
                break;

                default:
                    return time;

        }

        //make sure time satisfy time specification
        long timeOffset = time % timeSection;
        if (timeOffset != 0) {
            if (timeOffset < timeSection/2) {
                time = time - timeOffset;
            } else {
                time = time - timeOffset + timeSection;
            }
        }
        if (timeType.equals("day")) {
            time = time - 60 * 60 * 8;
        }
        return time;
    }
}
