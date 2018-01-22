package com.jd.genericsstudy.test3;

public class StaticFieldTest<T> {
    private static final long START_TIME = System.nanoTime();

    public static void main(String[] args) {
        StaticFieldTest<Integer> instance1 = new StaticFieldTest<>();
        System.out.println(START_TIME);
        StaticFieldTest<Integer> instance2 = new StaticFieldTest<>();
        System.out.println(START_TIME);
        StaticFieldTest<Integer> instance3 = new StaticFieldTest<>();
        System.out.println(START_TIME);
    }
}
