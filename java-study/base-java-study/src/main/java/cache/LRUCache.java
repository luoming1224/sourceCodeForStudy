package cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>(20, 0.75f, true);
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.get(2);


        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }
}
