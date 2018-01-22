package com.jenkov.myapp;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MyClass {
    MyClass() {
        System.out.println("MyClass construct function!");
    }

    protected List<String> stringList = new ArrayList<>();

    public List<String> getStringList(){
        return this.stringList;
    }

    public static void main(String[] args) {
        try {

            MyClass myClass = MyClass.class.newInstance();

            Method method = MyClass.class.getMethod("getStringList", null);

            Type returnType = method.getGenericReturnType();

            if(returnType instanceof ParameterizedType){

                ParameterizedType type = (ParameterizedType) returnType;

                Type[] typeArguments = type.getActualTypeArguments();

                for(Type typeArgument : typeArguments){

                    Class typeArgClass = (Class) typeArgument;

                    System.out.println("typeArgClass = " + typeArgClass);

                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
