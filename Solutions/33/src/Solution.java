public class Solution {
    public int search1(int[] nums, int target) {
        // 能过OJ，不过没用上有序性
        for(int i = 0; i < nums.length;i++){
            if(nums[i] == target) return i;
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        // 先顺次寻找从哪里翻转，再二分
        int length = nums.length;
        if(length == 0) return -1;
        int first = nums[0];
        int i;
        for(i = 0; i < length;i++){
            int recent = nums[i];
            if(recent == target) return i;
            if(recent < first) break;
        }
        int start = i;
        int end = i + length - 1;
        int middle;
        while(start <= end){
            middle = start + (end - start) / 2;
            if(nums[middle % length] == target){
                return middle % length;
            } else if(nums[middle % length] < target){
                start = middle+1;
            } else {
                end = middle-1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        // 直接二分
        int length = nums.length;
        if(length == 0) return -1;
        int start = 0;
        int end = length - 1;
        int middle;
        while(start <= end){
            middle = start + (end - start) / 2;
            if(nums[middle] == target){
                return middle;
            } else if(nums[middle] < nums[end]){
                if(nums[middle] < target && nums[end] >= target){
                    start = middle+1;
                } else {
                    end = middle-1;
                }
            } else {
                if(nums[start] <= target && nums[middle] > target){
                    end = middle-1;
                } else {
                    start = middle+1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] a = {4,5,6,7,0,1,2};
        int result = new Solution().search(a, 9);
        System.out.println(result);
    }
}
