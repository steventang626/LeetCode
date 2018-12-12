import java.util.Arrays;

class Solution {
    // Time O(nlgn), Space O(1)
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i = i + 2) {
            swap(nums, i, i + 1);
        }
    }
    public void swap(int[] num, int first, int second) {
        int temp = num[first];
        num[first] = num[second];
        num[second] = temp;
    }

    // Time O(n), Space O(1)
    public void wiggleSort2(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0 && nums[i + 1] < nums[i]) || (i % 2 == 1 && nums[i + 1] > nums[i]))
            swap(nums, i, i + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,2,1,6,4};
        new Solution().wiggleSort2(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}