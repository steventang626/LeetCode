public class Solution {
    // Time O(n)
    // Space O(1)
    public int minSubArrayLen0(int s, int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1 && nums[0] >= s) return 1;
        int left = 0;
        int right = -1;
        int sum = 0;
        int result = nums.length + 1;
        while (left < nums.length) {
            if (sum < s) {
                right++;
                if (right >= nums.length) break;
                else {
                    sum += nums[right];
                    if (sum >= s) {
                        if (left == right) return 1;
                        result = Math.min(result, right - left + 1);
                        sum -= nums[left];
                        left++;
                    }
                }
            } else {
                if (left == right) return 1;
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        if (result == nums.length + 1) return 0;
        else return result;
    }

    // 写法更精炼
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = -1;
        int sum = 0;
        int result = nums.length + 1;
        while (left < nums.length) {
            if (sum < s) {
                if (right < nums.length - 1) {
                    right++;
                    sum += nums[right];
                } else break;
            } else {
                sum -= nums[left];
                left++;
            }
            if (sum >= s) {
                if (left == right) return 1;
                result = Math.min(result, right - left + 1);
            }
        }
        if (result == nums.length + 1) return 0;
        else return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(new Solution().minSubArrayLen(7, nums));
    }

}
