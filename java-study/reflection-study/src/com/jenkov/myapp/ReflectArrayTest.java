package com.jenkov.myapp;

import java.lang.reflect.Array;

public class ReflectArrayTest {
    public static void main(String[] args) {
        int[] intArray = (int[]) Array.newInstance(int.class, 3);
        Array.set(intArray, 0, 123);
        Array.set(intArray, 1, 456);
        Array.set(intArray, 2, 789);

        System.out.println("intArray[0] = " + Array.get(intArray, 0));
        System.out.println("intArray[1] = " + Array.get(intArray, 1));
        System.out.println("intArray[2] = " + Array.get(intArray, 2));

        Class stringArrayClass1 = Array.newInstance(String.class, 0).getClass();
        System.out.println("is array: " + stringArrayClass1.isArray());


        String[] strings = new String[3];

        Class stringArrayClass = strings.getClass();

        Class stringArrayComponentType = stringArrayClass.getComponentType();

        System.out.println(stringArrayComponentType);


    }
}
