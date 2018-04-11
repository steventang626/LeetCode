public class Solution {
    public int searchInsert(int[] nums, int target) {
        // 两次二分
        int result = 0;
        int length = nums.length;
        if(length == 0) return result;
        int start = 0;
        int end = length - 1;
        int middle = 0;
        while(start <= end){
            middle = start + (end - start) / 2;
            if(nums[middle] == target){
                return middle;
            }
            else if(nums[middle] < target){
                start = middle+1;
            } else {
                end = middle-1;
            }
        }
        return start;
    }
    public static void main(String[] args){
        int[] a = {1,3,5,6};
        int result = new Solution().searchInsert(a, 0);
        System.out.println(result);
    }
}
