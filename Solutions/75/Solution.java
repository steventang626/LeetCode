public class Solution {
    public void sortColors(int[] nums) {
        if(nums.length <= 1) return;
        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        while(i < nums.length){
            if(nums[i] == 0 && i >= start){
                nums[i] = nums[start];
                nums[start] = 0;
                start++;
                i++;
            }else if(nums[i] == 2 && i < end){
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
            }else{
                i++;
            }
        }
    }
    public void sortColors1(int[] nums) {
        if(nums.length <= 1) return;
        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        while(i <= end){
            if(nums[i] == 0){
                nums[i] = nums[start];
                nums[start] = 0;
                start++;
                i++;
            }else if(nums[i] == 2){
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
            }else{
                i++;
            }
        }
    }
    public static void main(String[] args){
        int[] nums = {2,0,1};
        new Solution().sortColors1(nums);
        for (int i:nums) {
            System.out.print(i+" ");
        }
    }
}
