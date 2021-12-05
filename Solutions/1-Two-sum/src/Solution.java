public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] result = {0, 0};
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4};
        int target = 6;
        int[] result = new Solution().twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);

    }
}