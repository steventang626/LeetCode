import java.util.HashMap;

public class Solution {
    // use hashMap, Time O(n), Space O(n)
    public int majorityElement(int[] nums) {
        int majority = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        int recent;
        for(int i = 0; i < nums.length; i++) {
            recent = nums[i];
            if(map.containsKey(recent)) {
                map.replace(recent, map.get(recent) + 1);
            } else {
                map.put(recent, 1);
            }
            if(map.get(recent) > majority) {
                return recent;
            }
        }
        return 0;
    }

    // Boyer-Moore Voting Algorithm, Time O(n), Space O(1)
    public int majorityElement2(int[] nums) {
        int result = 0, score = 0;
        for(int num: nums) {
            if(score == 0) {
                result = num;
                score++;
            } else {
                if(num != result) score--;
                else score++;
            }
        }
        return result;
    }

    // compare with each digit, Time O(n), Space O(1)
    public int majorityElement3(int[] nums) {
        int majority = nums.length / 2;
        int result = 0;
        for(int i = 0; i < 32; i++) {
            int ones = 0, zeros = 0;
            for(int num: nums) {
                if(ones > majority || zeros > majority) {
                    break;
                }
                if((num & (1 << i)) != 0) {
                    ones++;
                } else {
                    zeros++;
                }
            }
            if(ones > zeros) {
                result += 1 << i;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,2,1};
        System.out.println(new Solution().majorityElement2(nums));
    }
}
