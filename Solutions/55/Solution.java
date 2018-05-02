public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(max >= i){
                max = Math.max(max, nums[i] + i);
            }
        }
        if(max >= nums.length - 1)
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        int[] a = {3,2,0,1,4};
        boolean result = new Solution().canJump(a);
        System.out.println(result);
    }
}
