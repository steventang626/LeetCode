public class Solution {
    public int pivotIndex(int[] nums) {
        int length = nums.length;
        int sum = 0, left = 0, right;
        for(int i: nums) sum += i;
        right = sum;
        for(int i = 0; i < length; i++) {
            right = right - nums[i];
            if(left == right) return i;
            left += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -1, 0, 1, 1, 0};
        int result = new Solution().pivotIndex(nums);
        System.out.println(result);
    }
}
