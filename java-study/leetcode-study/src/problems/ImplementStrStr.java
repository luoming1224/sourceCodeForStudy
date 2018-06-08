package problems;

public class ImplementStrStr {
    private static void getNextVal(char[] p, int[] next){
        int pLen = p.length;
        next[0] = -1;
        int k = -1, j = 0;
        while (j < pLen -1) {
            if (k == -1 || p[j] == p[k]) {
                ++j;
                ++k;
                if (p[j] != p[k]) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
    }

    private static int kmpSearch(char[] s, char[] p, int[] next) {
        int i = 0, j = 0;
        int sLen = s.length, pLen = p.length;
        while (i < sLen && j < pLen) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int strStr_kmp(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        } else if (haystack.length() == 0) {
            return -1;
        }

        int[] next = new int[needle.length()];
        char[] strHaystack = haystack.toCharArray();
        char[] strNeedle = needle.toCharArray();
        getNextVal(strNeedle, next);
        return kmpSearch(strHaystack, strNeedle, next);
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        char first = needle.charAt(0);
        int max = haystack.length() - needle.length();
        for (int i = 0; i <= max; i++) {
            if (haystack.charAt(i) != first) {
                while (++i <= max && haystack.charAt(i) != first);
            }

            if (i <= max) {
                int j = i + 1;
                int end = j + needle.length() - 1;
                for (int k = 1; j < end && haystack.charAt(j) == needle.charAt(k); j++, k++);

                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println( Math.abs(Integer.MIN_VALUE)  );


        String haystack = "", needle = "lloo";
//        String haystack = "", needle = "";
//        System.out.println(strStr(haystack, needle));
    }
}
