public class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        int end = 0;
        int length = nums.length;
        while(end<length){
            if(nums[end] != nums[start]){
                start = start + 1;
                nums[start] = nums[end];
            }
            end = end + 1;
        }
        return start + 1;
    }

    public static void main(String[] args){
        int[] nums = {1,1,2};
        int r = new Solution().removeDuplicates(nums);
        System.out.println(r);
        for(int i =0;i <r;i++){
            System.out.println(nums[i]);
        }
    }
}
