package problems;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {

        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = numRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();



    /*    if (numRows <= 0)
            return s;
        if (s.length() <= numRows  || numRows == 1)
            return s;
        StringBuilder builder = new StringBuilder(s.length());
        for (int i = 0; i < numRows; ++i) {
            int k = 0;
            for (int j = i; j < s.length(); ) {

                builder.append(s.charAt(j));
                if ((i == 0) || (i == numRows -1)) {
                    j += ((numRows << 1) - 2);
                } else {

                    j += ((1^k)*((numRows<<1)-2-(2*i)) + k*(2*i));
                    k = 1 ^ k;
                }
            }
        }

        return builder.toString();*/
    }

    public static void main(String[] args) {


        String s1 = convert("PAYPALISHIRING", 3);
        System.out.println(s1.equals("PAHNAPLSIIGYIR"));

        String s2 = convert("PAYPALISHIRING", 4);
        System.out.println(s2.equals("PINALSIGYAHRPI"));

        String s3 = convert("", 1);
        System.out.println(s3.equals(""));

        String s4 = convert("PAYPALISHIRING", 1);
        System.out.println(s4.equals("PAYPALISHIRING"));

        System.out.println(convert("ABCDE", 4).equals("ABCED"));
    }
}
