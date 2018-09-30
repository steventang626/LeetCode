public class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int currentMax = nums[0];
        for(int i = 1;i < nums.length; i++){
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            result = Math.max(result, currentMax);
        }
        return result;
    }
    public static void main(String[] args){
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = new Solution().maxSubArray(a);
        System.out.println(result);
    }
}
