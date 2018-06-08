package problems;

public class SearchforRange {
    public static int searchFirstIndex(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r)/2;
            if (target == nums[mid]) {
                if (mid > 0 && nums[mid - 1] == target) {
                    r = mid - 1;
                } else {
                    return mid;
                }
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public static int searchLastIndex(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r)/2;
            if (target == nums[mid]) {
                if ((mid < nums.length - 1) && nums[mid + 1] == target) {
                    l = mid + 1;
                } else {
                    return mid;
                }
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        /*
        int f = searchFirstIndex(nums, target);
        if (f == -1) {
            return new int[]{-1, -1};
        }
        int l = searchLastIndex(nums, target);
        return new int[]{f, l};
*/

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int l = 0, r = nums.length - 1;
        int l2 = 0, r2 = r;
        int first = -1, last = -1;
        while (l <= r || l2 <= r2) {
            int mid = (l + r)/2;
            int m2 = (l2 + r2)/2;
            if (target == nums[mid]) {
                if (mid > 0 && nums[mid - 1] == target) {
                    r = mid - 1;
                } else {
                    first = mid;
                }

            } else if (target < nums[mid]) {
                r = mid - 1;

            } else {
                l = mid + 1;

            }

            if (target == nums[m2]) {
                if ((m2 < nums.length - 1) && nums[m2 + 1] == target) {
                    l2 = m2 + 1;
                } else {
                    last = m2;
                }
            } else if (target < nums[m2]) {
                r2 = m2 - 1;
            } else {
                l2 = m2 + 1;
            }

            if (first != -1 && last != -1) break;
        }

        if (first == -1 && last == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{first, last};

    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};

        int[] res = searchRange(nums, 8);
        System.out.println(res[0] + " " + res[1]);
    }
}
