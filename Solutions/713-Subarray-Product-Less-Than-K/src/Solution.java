public class Solution {
    //Time Limit Exceeded
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            int product = nums[i];
            int j = i;
            while(product < k) {
                result++;
                if (j + 1 < nums.length) {
                    product = product * nums[j + 1];
                    j++;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if(k <= 1) return 0;
        int result = 0, left = 0, product = 1;
        for(int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while(product >= k) product /= nums[left++];
            result += i - left + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        int k =100;
        System.out.println(new Solution().numSubarrayProductLessThanK2(nums, k));
    }
}
