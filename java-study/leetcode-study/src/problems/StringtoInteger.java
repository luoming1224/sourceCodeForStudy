package problems;

public class StringtoInteger {
    public static int myAtoi(String str) throws Exception {

        if (str.isEmpty()) return 0;
        int sign = 1, base = 0, i = 0;
        while (str.charAt(i) == ' ')
            i++;
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '-' ? -1 : 1;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;

      /*  str  = str.trim();
        int i = 0, signal = 1;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            ++i;
            if (str.charAt(0) == '-')
                signal = -1;
        }
        int result = 0;
        for (; i < str.length(); ++i) {
            if (!(str.charAt(i) >= 0x30 && str.charAt(i) <= 0x39))
                break;
            System.out.println(Integer.MIN_VALUE + result * 10 );
            if (signal == 1 && ((str.charAt(i) - 0x30) > (Integer.MAX_VALUE - result * 10)))
                return Integer.MAX_VALUE;
            else if (signal == -1 && ((str.charAt(i) - 0x30) > (signal * result * 10 + Integer.MIN_VALUE)))
                return Integer.MIN_VALUE;

            result = result * 10 + signal * (str.charAt(i) - 0x30);
        }
        return result;*/
    }

    public static void main(String[] args) {



        try {
//            System.out.println(myAtoi("-12"));
            System.out.println(myAtoi("-2147483648"));
//            System.out.println(myAtoi("2147483647"));
//            System.out.println(myAtoi("2147483650"));
//            System.out.println(myAtoi("  +123abc"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
