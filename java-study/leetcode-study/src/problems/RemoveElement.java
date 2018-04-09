package problems;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        int i = 0, j = 0;
        for (; j < nums.length; ++j) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                ++i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 2, 2, 3, 4, 4, 5};
        int[] nums = {3, 2, 2, 3};
        int len = removeElement(nums, 3);
        System.out.println(len);
        for (int i = 0; i < len; ++i) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
