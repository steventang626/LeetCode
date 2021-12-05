public class Solution1 {

    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos == k - 1) {
                return nums[pos];
            } else if (pos > k - 1) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    private static int partition(int[] nums, int start, int end) {
        int mid = nums[start], i = start, j = end;
        while (i < j) {
            while (i < j && nums[j] <= mid) {
                j--;
            }
            while (i < j && nums[i] >= mid) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, start, i);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(new Solution1().findKthLargest(nums, k));
    }
}
