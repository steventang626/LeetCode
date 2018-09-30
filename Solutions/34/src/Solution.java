public class Solution {
    public int[] searchRange1(int[] nums, int target) {
        int[] result = {-1,-1};
        int length = nums.length;
        int start = 0;
        int end = length - 1;
        int middle;
        int found = -1;
        while(start <= end){
            middle = start + (end - start) / 2;
            if(nums[middle] == target){
                found = middle;
                break;
            } else if(nums[middle] < target){
                start = middle+1;
            } else {
                end = middle-1;
            }
        }
        if(found >= 0){
            int num_found = nums[found];
            int i,j;
            for(i = found; i>=0; i--){
                if(nums[i] == num_found) result[0] = i;
            }
            for(j = found; j<length; j++){
                if(nums[j] == num_found) result[1] = j;
            }
        }
        return result;
    }
    public int[] searchRange(int[] nums, int target) {
        // 两次二分
        int[] result = {-1,-1};
        int length = nums.length;
        if(length == 0) return result;
        int start = 0;
        int end = length - 1;
        int middle;
        while(start < end){
            middle = start + (end - start) / 2;
            if(nums[middle] < target){
                start = middle+1;
            } else {
                end = middle;
            }
        }
        if(nums[end] != target) return result;
        result[0] = end;
        end = length; // 注意此处不是length-1，因为最后要减1
        while(start < end){
            middle = start + (end - start) / 2;
            if(nums[middle] <= target){
                start = middle+1;
            } else {
                end = middle;
            }
        }
        result[1] = start - 1;
        return result;
    }
    public static void main(String[] args){
        int[] a = {1,1,2,2,3};
        int[] result = new Solution().searchRange(a, 1);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
