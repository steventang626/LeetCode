import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums, int target) {
        //遍历一个变量，数组直接排序，然后不引入List，加速很多
        List<List<Integer>> threeSum = new ArrayList<>();
        int length = nums.length;
        for(int i = 0; i <length-2; i++){
            if(i>0 && nums[i]==(nums[i-1])) continue;
            int j = i+1;
            int k = length-1;
            int sum = target-nums[i];
            while (j < k){
                int twoSum = nums[j] + nums[k];
                if(twoSum == sum){
                    List<Integer> three = new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k]));
                    threeSum.add(three);
                    while(j<k && nums[j]==nums[j+1]) j++;
                    while(j<k && nums[k]==nums[k-1]) --k;
                    j++;
                    k--;
                } else if(twoSum < sum){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return threeSum;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> fourSum = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i <length-3; i++){
            if(i>0 && nums[i]==(nums[i-1])) continue;
            List<List<Integer>> threeSums = threeSum(Arrays.copyOfRange(nums,i+1,length), target - nums[i]);
            for(int j = 0; j< threeSums.size(); j++){
                List<Integer> three = threeSums.get(j);
                List<Integer> four = new ArrayList<Integer>(Arrays.asList(nums[i], three.get(0), three.get(1), three.get(2)));
                fourSum.add(four);
            }
        }
        return fourSum;
    }

    public static void main (String[] args){
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        List<List<Integer>> ret = new Solution().fourSum(nums,-11);
        System.out.print(ret);
    }
}
