public class Solution {
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0) return false;
        int start = 0;
        int end = length - 1;
        int middle;
        while(start <= end){
            middle = start + (end - start) / 2;
            if(nums[middle] == target){
                return true;
            } else if(nums[middle] < nums[end]){
                if(nums[middle] < target && nums[end] >= target){
                    start = middle+1;
                } else {
                    end = middle-1;
                }
            } else if(nums[middle] > nums[end]){
                if(nums[start] <= target && nums[middle] > target){
                    end = middle-1;
                } else {
                    start = middle+1;
                }
            } else{
                boolean inRight = false;
                for(int i = middle + 1; i < end; i++){
                    if(nums[i] != nums[middle]){
                        inRight = true;
                        break;
                    }
                }
                if(inRight){
                    start = middle+1;
                }else{
                    end = middle-1;
                }
            }
        }
        return false;
    }

    public boolean search2(int[] nums, int target) {
        int length = nums.length;
        if(length == 0) return false;
        int start = 0;
        int end = length - 1;
        int middle;
        while(start <= end){
            middle = start + (end - start) / 2;
            if(nums[middle] == target){
                return true;
            } else if(nums[middle] < nums[end]){
                if(nums[middle] < target && nums[end] >= target){
                    start = middle+1;
                } else {
                    end = middle-1;
                }
            } else if(nums[middle] > nums[end]){
                if(nums[start] <= target && nums[middle] > target){
                    end = middle-1;
                } else {
                    start = middle+1;
                }
            } else{
                end--;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] a = {3,1,1};
        boolean result = new Solution().search2(a, 3);
        System.out.println(result);
    }
}
