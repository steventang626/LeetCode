public class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int l = j; l < length; l++) {
            nums[l] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {
        int length = nums.length;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                if (i == j) {
                    j++;
                } else {
                    swap(nums, i, j++);
                }
            }
        }
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes1(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
