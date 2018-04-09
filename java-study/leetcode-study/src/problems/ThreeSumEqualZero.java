package problems;

import java.util.*;

public class ThreeSumEqualZero {
    public static List<List<Integer>> threeSum(int[] nums) {
       return null;
    }

    public static void main(String[] args) {
        int[] S = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> lists = threeSum(S);

        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
