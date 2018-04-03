public class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = 0;
        int length = nums.length;
        while(end<length){
            if(nums[end] != val){
                nums[start] = nums[end];
                start = start + 1;
            }
            end = end + 1;
        }
        return start;
    }

    public static void main(String[] args){
        int[] nums = {3,2,2,3};
        int r = new Solution().removeElement(nums,3);
        System.out.println(r);
        for(int i =0;i <r;i++){
            System.out.println(nums[i]);
        }
    }
}
