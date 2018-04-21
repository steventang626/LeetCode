import java.util.ArrayList;

public class Solution {
    public int jump(int[] nums) {
        // 超时
        int length = nums.length;
        if(length == 1) return 0;
        if(nums[0] >= length - 1) return 1;

        ArrayList<Integer>[] step_can_reach = new ArrayList[length];
        for(int i = 0; i < length; i++){
            step_can_reach[i] = new ArrayList<>();
        }
        int[] steps = new int[length];
        for(int i = 0; i < length; i++){
            for(int j = 1; (j <= nums[i] && (i + j) < length); j++){
                step_can_reach[i+j].add(i);
            }
        }
        steps[0] = 0;

        for(int i = 1; i < length; i++){
            int recent = 10000000;
            for(int j = 0; j < step_can_reach[i].size(); j++){
                recent = Math.min(recent, steps[step_can_reach[i].get(j)] + 1);
            }
            steps[i] = recent;
        }
        return steps[length - 1];
    }

    public int jump1(int[] nums) {
        int length = nums.length;
        if(length == 1) return 0;
        if(nums[0] >= length - 1) return 1;

        int[] steps = new int[length];
        for(int i = 1; i < length; i++){
            steps[i] = 1000000;
        }
        steps[0] = 0;
        int recent = 0;
        for(int i = 0; i < length; i++){
            for(int j = Math.min(nums[i], length - 1 - i); (j >=1 && (i + j) > recent); j--){
                steps[i + j] = Math.min(steps[i] + 1, steps[i + j]);
                if(i + j == length - 1) break;
            }
            //if(steps[length - 1] != 1000000) break;
            recent = i + nums[i];
            if(recent >= length - 1) break;
        }
        return steps[length - 1];
    }

    public static void main(String[] args){
        int[] a = {1,2,1,1,1};
        int result = new Solution().jump1(a);
        System.out.println(result);
    }
}
