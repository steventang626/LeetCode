public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int length = nums.length;
        for (int i =0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (int)((1 + length) * length * 0.5) - sum;
    }

    public int missingNumber2(int[] nums) {
        int res = 0;
        for (int i =0; i < nums.length; i++) {
            res ^= (i + 1) ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(new Solution().missingNumber2(nums));
    }
}