import java.util.HashSet;

public class Solution {
    // Simplified
    // Time O(n)
    // Space O(k)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
            if (set.size() == k + 1)
                set.remove(nums[i - k]);
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return false;
        int left = 0;
        int right = Math.min(k, nums.length - 1);
        HashSet<Integer> set = new HashSet<>();
        for (int i = left; i <= right; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        while (right + 1 < nums.length) {
            set.remove(nums[left]);
            left++;
            right++;
            if (set.contains(nums[right])) {
                return true;
            } else {
                set.add(nums[right]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        System.out.println(new Solution().containsNearbyDuplicate(nums, 1));
    }
}
