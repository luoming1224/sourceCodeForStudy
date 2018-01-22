package basicstudy;

class Data {
    {
        System.out.println("Data class block");
    }
    static {
        System.out.println("Data class static block***********");
    }
    public Data() {
        System.out.println("Data class constructor");
    }
}
class Parent{
    static String name = "hello";
    {
        System.out.println("parent block");
    }
    static {
        System.out.println("parent static block");
    }
    public Parent(int a){
        System.out.println("parent constructor");
    }
}

class Child extends Parent{
    static String childName = "hello";

    {
        System.out.println("child block");
    }
    static {
        System.out.println("child static block");
    }

    public Child(){
        super(1);
        System.out.println("child constructor");
    }

    Data data = new Data();
}

public class StaticIniBlockOrderTest {
    /*{
        System.out.println("Test block*****");
    }
    static Data data = new Data();
    static {
        System.out.println("Test static block");
    }*/
    public static void main(String[] args) {
        new Child();//语句(*)
    }
}
