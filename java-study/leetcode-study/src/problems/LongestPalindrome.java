package problems;

public class LongestPalindrome {

    public static boolean isPalindrome(String s, int start, int end) {
        int i, j;
        if ((end - start + 1) % 2 == 0) {
            i = (start + end) / 2;
            j = i + 1;
        } else {
            int mid = (start + end) / 2;
            i = mid -1;
            j = mid + 1;
        }
        while (i >= start) {
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i -= 1;
            j += 1;
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        int maxLen = 1;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i+1; j < s.length(); ++j) {
                if (isPalindrome(s, i, j)) {
                    int len = j - i + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        if (maxLen > 1) {
            return s.substring(start, end + 1);
        }
        return s.substring(0, 1);

    }

    public static void main(String[] args) {
        String a = "babad";
        System.out.println(longestPalindrome(a));

        String b = "cbbd";
        System.out.println(longestPalindrome(b));

        String c = "aaaaa";
        System.out.println(longestPalindrome(c));
    }
}
