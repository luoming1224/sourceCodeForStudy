package com.jd.plain.test1;

public class Test {
    public static void main(String[] args) {

        int minNewCapacity = 1048576 * 4 + 1048576 * 4 - 1;
        System.out.println("minNewCapacity: " + minNewCapacity);

        final int threshold = 1048576 * 4; // 4 MiB page
        System.out.println("threshold: " + threshold);

        // If over threshold, do not double but just increase by threshold.

        int newCapacity = minNewCapacity / threshold * threshold;
        System.out.println("newCapacity: " + newCapacity);


    }
}
