package adapterpattern;

public class Adapter extends Adaptee implements Target {
    @Override
    public void sampleOperation2() {

        sampleOperation1();
        //写相关的代码
        System.out.println("Adapter sampleOperation2");
    }
}
