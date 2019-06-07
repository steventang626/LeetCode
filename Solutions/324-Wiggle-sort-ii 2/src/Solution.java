import java.util.Arrays;

class Solution {
    // Time O(nlgn), Space O(n)
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int[] nums2 = new int[length];
        int num = (length + 1) / 2 - 1;
        for(int i = 0; i < (length + 1) / 2; i++) {
            nums2[i * 2] = nums[num - i];
        }
        for(int i = (length + 1) / 2; i < length; i++) {
            nums2[(i - num) * 2 - 1] = nums[length + num - i];
        }
        for(int i = 0; i < length; i++) {
            nums[i] = nums2[i];
        }
    }

    // Time O(n), Space O(1)
    public void wiggleSort2(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        // Ready to continue
    }

    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1) return nums[0];
        int mid = nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (nums[right] > mid && left < right) right--;
            while (nums[left] <= mid && left < right) left++;
            swap(nums, left, right);
        }
        nums[0] = nums[left];
        nums[left] = mid;

        if (left == nums.length - k) return mid;
        else if (left < nums.length - k) {
            return findKthLargest(Arrays.copyOfRange(nums, left + 1, nums.length), k);
        } else {
            return findKthLargest(Arrays.copyOfRange(nums, 0, left), k  + left - nums.length);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,1,1,6,4};
        new Solution().wiggleSort(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}