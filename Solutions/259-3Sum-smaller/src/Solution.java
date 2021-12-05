import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        System.out.println(new Solution().threeSumSmaller(nums, target));
    }

    // Time O(n^2), Space O(1)
    public int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            result += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return result;
    }

    public int twoSumSmaller(int[] nums, int start, int target) {
        int left = start, right = nums.length - 1, result = 0;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                result += right - left;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
