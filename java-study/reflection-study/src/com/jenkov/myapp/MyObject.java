package com.jenkov.myapp;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MyObject implements Serializable{
    public int a;
    private String b;

/*    MyObject(String b) {
        this.b = b;
    }

    MyObject(int a, String b) {
        this.a = a;
        this.b = b;
    }*/

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "a = " + a + " b = " + b;
    }

    public static void main(String[] args) {
        try {
            Class myObjectClass = MyObject.class;
            System.out.println("class = " + myObjectClass);
            System.out.println("className = " + myObjectClass.getName());
            System.out.println("className = " + myObjectClass.getSimpleName());
            System.out.println("classModifier = " + myObjectClass.getModifiers());
            System.out.println("classModifier = " + (Modifier.isPublic(myObjectClass.getModifiers()) ? "public" : "other"));
            System.out.println("classPackage = " + myObjectClass.getPackage());
            System.out.println("superClass = " + myObjectClass.getSuperclass());

            Class[] interfaces = myObjectClass.getInterfaces();
            for (Class interfacee : interfaces) {
                System.out.println("interfaces: " + interfacee);
            }


                Constructor constructor = MyObject.class.getConstructor();
                MyObject myObject = (MyObject)constructor.newInstance();
                myObject.setA(10);
                myObject.setB("abcd");
                System.out.println(myObject);

            Field[] fields = myObjectClass.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            Field field = myObjectClass.getField("a");
            Object value = field.get(myObject);
            System.out.println("a:" + value);
            field.set(myObject, 20);
            System.out.println(myObject);


            Method[] methods = MyObject.class.getMethods();

            for(Method method : methods){

    //            System.out.println("method = " + method.getName());

            }

            Method method = myObjectClass.getMethod("toString", null);
            String str = (String) method.invoke(myObject);
            System.out.println("method return: " + str);

            Field privateStringField = myObjectClass.getDeclaredField("b");
            privateStringField.setAccessible(true);
            String fieldValue = (String)privateStringField.get(myObject);
            System.out.println("privateFieldValue: b = " + fieldValue);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
