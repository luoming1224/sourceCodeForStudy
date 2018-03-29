package jvm;

import javax.swing.*;
import java.io.*;

public class MyClassLoader extends ClassLoader{
    private String root;

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
//            String fileName = root + File.separatorChar + name.replace('.', File.separatorChar) + ".class";
            System.out.println("--------------------");
            System.out.println(getClass());
            System.out.println("--------------------");
            InputStream is = getClass().getResourceAsStream(fileName);
            if (is == null) {
                return super.loadClass(name);   // 递归调用父类加载器
            }
            byte[] b = new byte[is.available()];
            is.read(b);
            return defineClass(name, b, 0, b.length);
        } catch (Exception e) {
            throw new ClassNotFoundException(name);
        }
    }

  /*  protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] loadClassData(String className) {
        String fileName = root + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        System.out.println(fileName);
        try {
            InputStream ins = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public static void main(String[] args) {
        MyClassLoader classLoader = new MyClassLoader();
//        classLoader.setRoot("/home/luoming/Documents");
//        classLoader.setRoot("/home/luoming/sourceCodeForStudy/java-study/base-java-study/target/classes");
        Class<?> testClass = null;
        try {
            testClass = classLoader.loadClass("jvm.Test2");
//            Class<?> class0 = classLoader.loadClass("jvm.Test2");
            Object object = testClass.newInstance();
            Object object2 = testClass.newInstance();
            System.out.println(object.getClass());
            System.out.println(object.getClass().getClassLoader());

            Class<?> class0 = testClass.forName("jvm.Test2");
            System.out.println("** " + (testClass.equals(class0)));
//            System.out.println(classLoader.getParent());

//            System.out.println(getSystemClassLoader());

            Class<?> class1 = getSystemClassLoader().loadClass("jvm.Test2");
            Class<?> class2 = getSystemClassLoader().loadClass("jvm.Test2");
            Class<?> class3 = Class.forName("jvm.Test2");
            Object object1 = class1.newInstance();
//            System.out.println(testClass.equals(class0));
            System.out.println(testClass.equals(class1));
            System.out.println(class0.equals(class1));
            System.out.println(class1.equals(class2));
            System.out.println(class1 == class2);
            System.out.println(class1 == class3);
            System.out.println("object == object1 : " + (object == object1));
            System.out.println("object == object2 : " + (object == object2));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
