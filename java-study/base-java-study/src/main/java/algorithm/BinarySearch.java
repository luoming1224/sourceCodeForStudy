package algorithm;

public class BinarySearch {

    static int binarySearch(int[] data, int k) {
        int l = 0, r = data.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (data[m] < k) {
                l = m + 1;
            } else if (data[m] > k) {
                r = m -1;
            } else {
                return m;
            }
        }
        return -1;
    }
    public static void main(String[] args) {


        int[] data = {1, 2, 4, 6, 10, 15, 17, 19, 20, 21};
        System.out.println(binarySearch(data, 10));  //expect: 4
        System.out.println(binarySearch(data, 1));  //expect: 0
        System.out.println(binarySearch(data, 21));  //expect: 9
        System.out.println(binarySearch(data, 18));  //expect: -1

    }
}
