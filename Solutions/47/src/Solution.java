import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums){
        if(nums.length == 0) return null;
        List<List<Integer>> l1_1 = new ArrayList<>();
        List<Integer> l1_2 = new ArrayList<>();
        l1_2.add(nums[0]);
        l1_1.add(l1_2);
        if(nums.length == 1) return l1_1;
        List<List<Integer>> recent_result = permuteUnique(Arrays.copyOfRange(nums, 1,nums.length));
        Set<List<Integer>> result = new HashSet<>();
        for(int i =0; i<recent_result.size(); i++){
            List<Integer> recent_list = recent_result.get(i);
            for(int j = 0; j <= recent_list.size(); j++){
                List<Integer> new_list = new ArrayList<>();
                new_list.addAll(recent_list);
                new_list.add(j,nums[0]);
                result.add(new_list);
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args){
        int[] a = {1,1,2};
        List<List<Integer>> result = new Solution().permuteUnique(a);
        for(int i =0; i<result.size(); i++){
            List<Integer> recent = result.get(i);
            for(int j = 0; j < recent.size(); j++){
                System.out.print(recent.get(j)+" ");
            }
            System.out.println();
        }
    }
}
