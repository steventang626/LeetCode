public class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int i,j;
        i = length - 2;
        j = length - 1;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i >= 0){
            while(nums[i] >= nums[j]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while(end > start){
            swap(nums, start, end);
            end--;
            start++;
        }
    }

    public void swap(int[] nums, int a, int b) {
        int n = nums[a];
        nums[a] = nums[b];
        nums[b] = n;
    }

    public static void main(String[] args){
        int[] a = {1,2,4,3};
        new Solution().nextPermutation(a);
        for(int i = 0; i<a.length;i++){
            System.out.print(a[i]);
        }

    }
}
