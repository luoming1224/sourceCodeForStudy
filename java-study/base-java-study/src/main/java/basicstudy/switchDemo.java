package basicstudy;

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
        String s1 = "ab";
        String s2 = "abc";
        String s3 = s1 + "c";
        System.out.println(s3 == s2);
        System.out.println(s3.equals(s2));




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
    }
}
