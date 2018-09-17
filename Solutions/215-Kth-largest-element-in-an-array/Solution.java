import java.util.Arrays;

public class Solution {
    public int findKthLargest1(int[] nums, int k) {
        if(nums.length == 1) return nums[0];
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public int quickSelect(int[] nums, int start, int end, int k) {
        if(start == end) return nums[start];

        int mid = nums[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (nums[right] >= mid && left < right) right--;
            while (nums[left] <= mid && left < right) left++;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        nums[start] = nums[left];
        nums[left] = mid;

//        for(int i = start; i <= end; i++){
//            System.out.print(nums[i] + " ");
//        }
//        System.out.println(left + " left");

        if (left == nums.length - k) return mid;
        else if (left < nums.length - k) {
            return quickSelect(nums, left + 1, end, k);
        } else {
            return quickSelect(nums, start, left - 1, k);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1) return nums[0];
        int mid = nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (nums[right] >= mid && left < right) right--;
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
        int nums[] = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(new Solution().findKthLargest(nums, k));
    }
}
