import java.util.TreeSet;

public class Solution {
    // Time O(nlogn)
    // Space O(k)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.ceiling((long) nums[i] - (long) t) != null && set.ceiling((long) nums[i] - t) <= (long) nums[i] + (long) t) {
                return true;
            } else {
                set.add((long) nums[i]);
            }
            if (set.size() == k + 1)
                set.remove((long) nums[i - k]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,9,1,5,9};
        System.out.println(new Solution().containsNearbyAlmostDuplicate(nums, 2, 3));
    }
}
