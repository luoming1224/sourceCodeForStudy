package problems;

public class IntegertoRoman {
    private static final String p[][] = {
            {"","I","II","III","IV","V","VI","VII","VIII","IX"},
            {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
            {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
            {"","M","MM","MMM"}
    };
    public static String intToRoman(int num) {


        StringBuilder builder = new StringBuilder();
        builder.append(p[3][num / 1000]);
        builder.append(p[2][num / 100 % 10]);
        builder.append(p[1][num /10 % 10]);
        builder.append(p[0][num % 10]);

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1));
        System.out.println(intToRoman(2));
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(5));
        System.out.println(intToRoman(6));
        System.out.println(intToRoman(7));
        System.out.println(intToRoman(8));
        System.out.println(intToRoman(10));
        System.out.println(intToRoman(100));
        System.out.println(intToRoman(3999));
    }
}
