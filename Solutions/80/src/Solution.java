public class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        int end = 1;  // changed
        int length = nums.length;
        int sum = 0;
        if(length == 1) return length; // changed
        while(end<length){
            if(nums[end] != nums[start]){
                start = start + 1;
                nums[start] = nums[end];
                sum = 0;
            }else{
                sum++;
                if(sum < 2){
                    start = start + 1;
                    nums[start] = nums[start - 1]; // changed
                }
            }
            end = end + 1;
        }
        return start + 1;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,1,1,2,3};
        int r = new Solution().removeDuplicates(nums);
        System.out.println(r);
        for(int i =0;i <r;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
