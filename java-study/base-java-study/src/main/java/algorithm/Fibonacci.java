package algorithm;

public class Fibonacci {

    static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int pre = 0;
        int post = 1;
        int fn = 0;
        for (int i = 2; i <= n; ++i) {
            fn = pre + post;
            pre = post;
            post = fn;
        }
        return fn;
    }
    public static void main(String[] args) {

        for (int i = 0; i <= 10; i++) {
            System.out.println(fibonacci(i));
        }

    }
}
