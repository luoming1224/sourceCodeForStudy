package collectionstudy;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {

        int rs = 32795;
        int ss = rs + (1 << (32 - 16)) - 1;
        System.out.println(ss);
        System.out.printf("%x", ss);
        System.out.println();
        int sc;
        sc = rs << 16;
        sc += 2;



      /*  System.out.println(Integer.numberOfLeadingZeros(-100));
        System.out.println(Integer.numberOfLeadingZeros(8));
        System.out.println(Integer.numberOfLeadingZeros(16));
        System.out.println(Integer.numberOfLeadingZeros(32));
        System.out.println(Integer.numberOfLeadingZeros(64));

        int rs = 32795;
        System.out.println(rs);
        System.out.printf("%x", rs);
        System.out.println();
        rs += 1;
        System.out.println(rs);
        System.out.printf("%x", rs);
        System.out.println();
        rs = rs << 16;
        System.out.println(rs);
        System.out.printf("%x", rs);
        System.out.println();

        rs += 2;
        System.out.println(rs);
        System.out.printf("%x", rs);
        System.out.println();

        rs += 1;
        System.out.println(rs);
        System.out.printf("%x", rs);
        System.out.println();
*/

/*
        HashMap<Integer, String> hashMap = new HashMap<>(15);
        for (int i = 0; i < 15; ++i) {
            hashMap.put(i, "a");
        }
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>(8);
        map.put(1, "a");
        map.putAll(hashMap);*/

    }
}
