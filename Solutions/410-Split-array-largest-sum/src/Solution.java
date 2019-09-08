public class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int maxValue = 0;
        for (int i : nums) {
            sum += i;
            maxValue = Math.max(maxValue, i);
        }
        int left = maxValue;
        int right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, m, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // More safer way to write binary search
    public int splitArray2(int[] nums, int m) {
        int sum = 0;
        int maxValue = 0;
        for (int i : nums) {
            sum += i;
            maxValue = Math.max(maxValue, i);
        }
        int left = maxValue;
        int right = sum;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, m, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return (left == right || canSplit(nums, m, left)) ? left : right;
    }

    private boolean canSplit(int[] nums, int m, int maxSum) {
        int numOfSplit = 1;
        int sum = 0;
        for (int num : nums) {
            if (sum + num > maxSum) {
                numOfSplit++;
                sum = num;
            } else {
                sum += num;
            }
        }
        return numOfSplit <= m;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        System.out.println(new Solution().splitArray2(nums, m));
    }
}
