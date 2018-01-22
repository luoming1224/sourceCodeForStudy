package Exceptionstudy;

/**
 * 在try-catch-finally中，当try中有return语句时，先执行return后面的语句，并将计算结果压入栈中返回值位置，作为返回的结果
 * 再执行finally中的语句，当在finally中改变return语句中的作为返回值的变量的值时，
 * 如果返回变量为基本类型和String类型，不影响返回的结果
 * 如果返回变量为引用类型，改变引用类型返回变量的内容，则返回的内容也会改变;若改变返回变量的指向，指向其他对象或者null，不影响返回结果
 */
public class TryCatchTest {
    static String s = "A";

    public static void main(String[] args) {
        System.out.println(test3());
        System.out.println(s);

//        System.out.println(test1());

//        System.out.println(test11());

//        System.out.println(test2().getName());

    }

    private static String test() {
        try {
            System.out.println("A");
            return s = "A";
        } finally {
            System.out.println("B");
            s = "B";
        }
    }

    private static String test3() {
        try {
            System.out.println("A");
            return s = new String("A") ;
        } finally {
            System.out.println("B");
            s = "B";
        }
    }

    public static int test1() {
        int b = 20;

        try {
            System.out.println("try block");

            return b += 80;
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
        }

        return b;
    }

    public static String test11() {
        try {
            System.out.println("try block");

            return test12();
        } finally {
            System.out.println("finally block");
        }
    }

    public static String test12() {
        System.out.println("return statement");

        return "after return";
    }

    public static Student test2() {
        Student stu = new Student();

        try {
            stu.setName("Try");
            return stu;
        } catch (Exception e) {
            stu.setName("Catch");
        } finally {
            stu.setName("Finally");
            stu = new Student();
            stu.setName("Modify Again");
        }

        return stu;
    }
}

class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
