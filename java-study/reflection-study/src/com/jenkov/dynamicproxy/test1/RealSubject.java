package com.jenkov.dynamicproxy.test1;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("====RealSubject Request====");
    }
}
