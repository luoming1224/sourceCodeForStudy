package jvm;

import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderTest {
    public static void main(String[] args) {
        try {
            //查看当前系统类路径中包含的路径条目
            System.out.println(System.getProperty("java.class.path"));
            URL[] urls = ((URLClassLoader)ClassLoader.getSystemClassLoader()).getURLs();
            for (int i = 0; i < urls.length; i++) {
                System.out.println(urls[i]);
            }
            System.out.println();
            //调用加载当前类的类加载器（这里即为系统类加载器）加载TestBean
            Class typeLoaded = Class.forName("jvm.TestBean");
            //查看被加载的TestBean类型是被那个类加载器加载的
            System.out.println(typeLoaded.getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
