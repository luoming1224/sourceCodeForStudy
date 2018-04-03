package problems;

public class ReverseInteger {


    public static int reverse(int x) {

        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }


    /*    String s = Integer.toString(x);
        char[] c = s.toCharArray();
        int begin = 0, end = c.length - 1;
        int symbol = 0;
        if (c[0] == '-' || c[0] == '+'){
            begin++;
            symbol = 1;
        }
        while (end > 0 && (c[end] == '0')) {
            end--;
        }

        int len = end - begin + 1;
        int l, r;
        if (len % 2 == 0) {
            l = (end + begin) / 2;
            r = l + 1;
        } else {
            int m = (end + begin) / 2;
            l = m - 1;
            r = m + 1;
        }
        while (l >= begin && r <= end) {
            char t = c[l];
            c[l] = c[r];
            c[r] = t;
            l--;
            r++;
        }

        String res = new String(c, 0, len + symbol);

        int result = 0;

        try {
            result = Integer.valueOf(res);
        } catch (NumberFormatException e) {
            result = 0;
        }
*/

        return result;

    }

    public static void main(String[] args) {
        // -2147483648  2147483647;

//        System.out.println(reverse(-2147483648));
        System.out.println(reverse(2147483647));
//        System.out.println(reverse(123));
//        System.out.println(reverse(-123));
//        System.out.println(reverse(120));

    }
}
