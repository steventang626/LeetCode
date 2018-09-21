import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,3,2};
        System.out.println(new Solution().containsDuplicate(nums));
    }
}
