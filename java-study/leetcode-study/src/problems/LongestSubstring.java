package problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int maxLength = 0;
        for (int i = 0; i < s.length(); ) {
            map.put(s.charAt(i), i);
            int j;
            for (j = i + 1; j < s.length(); ++j) {
                if (map.containsKey(s.charAt(j))) {

                    int len = j - i;
                    if (len > maxLength) {
                        maxLength = len;
                    }

                    i = map.get(s.charAt(j)) + 1;
                    map.clear();
                    break;

                } else {
                    map.put(s.charAt(j), j);
                }
            }

            if (j == s.length()) {
                int len  = j - i ;
                if (len > maxLength)
                    maxLength = len;
                //map.clear();
                break;
            }

            if (maxLength >= (s.length() - i + 1)) {
                //map.clear();
                break;
            }
        }

        return maxLength;

    }

    public static void main(String[] args) {
        String s = "bbbbb";
        int max = lengthOfLongestSubstring(s);
        System.out.println(max);
    }
}
