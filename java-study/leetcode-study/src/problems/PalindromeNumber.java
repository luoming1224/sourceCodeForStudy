package problems;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x <0 || (x != 0 && x % 10 == 0 )) {
            return false;
        }

        int r = 0, t = x;
        while (x != 0) {
            int tail = x % 10;
            int newResult = r * 10 + tail;
            if ((newResult - tail) / 10 != r) {
                return false;
            }

            r = newResult;
            x = x/10;
        }

        return t==r;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));

        System.out.println(isPalindrome(-121));

        System.out.println(isPalindrome(1210));

        System.out.println(isPalindrome(1213));
        System.out.println(isPalindrome(-2147447412)); //-2147483648




    }
}
