import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numberMap.containsKey(target - nums[i])) {
                return new int[]{numberMap.get(target - nums[i]), i};
            }
            numberMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4};
        int target = 6;
        int[] result = new Solution().twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);

    }

}