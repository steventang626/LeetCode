import java.util.ArrayList;
import java.util.HashMap;

public class Solution2 {
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] result={0,0};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                result[0] = Math.min(i,map.get(complement));
                result[1] = Math.max(i,map.get(complement));
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums={2,3,4};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(result[0]+" "+result[1]);

    }

}