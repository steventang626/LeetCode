import java.util.Arrays;

public class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        int closest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i = 0; i <length-2; i++){
            if(i>0 && nums[i]==(nums[i-1])) continue;
            int j = i+1;
            int k = length-1;
            int sum = target-nums[i];
            while (j < k){
                int twoSum = nums[j] + nums[k];
                if(twoSum == sum){
                    return target;
                } else if(twoSum < sum){
                    if(sum - twoSum < Math.abs(closest - target)){
                        closest = twoSum + nums[i];
                    }
                    j++;
                } else {
                    if(twoSum - sum < Math.abs(closest - target)){
                        closest = twoSum + nums[i];
                    }
                    k--;
                }
            }
        }
        return closest;
    }

    public static void main (String[] args){
        int[] nums = {-1,2,1,-4};
        System.out.print(threeSumClosest(nums, 0));
    }
}
