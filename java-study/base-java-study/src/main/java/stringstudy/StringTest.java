package stringstudy;

import java.lang.reflect.Field;
import java.util.concurrent.locks.ReentrantLock;

public class StringTest {

    public static void testReflection() throws Exception {

        //创建字符串"Hello World"， 并赋给引用s
        String s = "Hello World";

        System.out.println("s = " + s); //Hello World

        //获取String类中的value字段
        Field valueFieldOfString = String.class.getDeclaredField("value");

        //改变value属性的访问权限
        valueFieldOfString.setAccessible(true);

        //获取s对象上的value属性的值
        char[] value = (char[]) valueFieldOfString.get(s);

        //改变value所引用的数组中的第5个字符
        value[5] = '_';

        System.out.println("s = " + s);  //Hello_World
    }

    private static void test01(){
        String s0 = "kvill";        // 1
        String s1 = "kvill";        // 2
        String s2 = "kv" + "ill";     // 3

        System.out.println(s0 == s1);       // true
        System.out.println(s0 == s2);       // true
    }

    private static void test02(){
        String s0 = "kvill";
        String s1 = new String("kvill");
        String s2 = "kv" + new String("ill");

        String s = "ill";
        String s3 = "kv" + s;


        System.out.println(s0 == s1);       // false
        System.out.println(s0 == s2);       // false
        System.out.println(s1 == s2);       // false
        System.out.println(s0 == s3);       // false
        System.out.println(s1 == s3);       // false
        System.out.println(s2 == s3);       // false
    }

    public static void changeStr(String str) {
        String s = str;
        str += "welcome";
        System.out.println(s);
    }

    public static void main(String[] args) {
        try {
            testReflection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String str = "1234";
        changeStr(str);
        System.out.println(str);

        test01();

        final String str8 = "cd";
        String str9 = "ab" + str8;
        String str89 = "abcd";
        System.out.println("str9 = str89 : "+ (str9 == str89));     // true


        String s = "a" + "b" + "c";
        String s1 = "a";
        String s2 = "b";
        String s3 = "c";
        String s4 = s1 + s2 + s3;

        System.out.println(s);
        System.out.println(s4);


        String ss = null;
        for(int i = 0; i < 100; i++) {
            ss += "a";
        }

        String a = "a\\b";
        System.out.println(a.split("\\\\")[0]);
        System.out.println(a.split("\\\\")[1]);
    }


  /*
    public static void main(String[] args) {
        String str0 = new StringBuilder("ja").append("va").toString();
        System.out.println(str0.intern() == str0);
        System.out.println(str0 == str0.intern());

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == str1.intern());

        String str2 = new StringBuilder("in").append("t").toString();
        System.out.println(str2.intern() == str2);
        System.out.println(str2 == str2.intern());

        String str3 = new StringBuilder("cha").append("r").toString();
        System.out.println(str3.intern() == str3);
        System.out.println(str3 == str3.intern());

*//*
        StringBuffer sb = new StringBuffer();
        String user = "test";
        String pwd = "123";
        sb.append("select * from userInfo where username=")
                .append(user)
                .append(" and pwd=")
                .append(pwd);*//*
    }

    */

}
