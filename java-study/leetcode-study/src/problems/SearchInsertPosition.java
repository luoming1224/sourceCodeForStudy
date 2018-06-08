package problems;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        int l = 0, r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r)/2;
            if (target == nums[mid]){
                return mid;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (target > nums[mid]) {
            return mid + 1;
        } else {
            return mid ;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5)); // 2

        nums = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums, 2)); // 1

        nums = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums, 7)); // 4

        nums = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums, 0)); // 0

        nums = new int[]{};
        System.out.println(searchInsert(nums, 0)); // 0

        nums = new int[]{1, 3};
        System.out.println(searchInsert(nums, 2)); // 1
    }
}
