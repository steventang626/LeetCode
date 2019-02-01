import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums){
        if (nums.length == 0) return null;
        List<List<Integer>> l1_1 = new ArrayList<>();
        List<Integer> l1_2 = new ArrayList<>();
        l1_2.add(nums[0]);
        l1_1.add(l1_2);
        if(nums.length == 1) return l1_1;
        List<List<Integer>> recent_result = permute(Arrays.copyOfRange(nums, 1,nums.length));
        List<List<Integer>> result = new ArrayList<>();
        for (int i =0; i<recent_result.size(); i++){
            List<Integer> recent_list = recent_result.get(i);
            for(int j = 0; j <= recent_list.size(); j++){
                List<Integer> new_list = new ArrayList<>(recent_list);
                new_list.add(j,nums[0]);
                result.add(new_list);
            }
        }
        return result;
    }

    private List<List<Integer>> result;
    private boolean[] used;
    public List<List<Integer>> permute2(int[] nums){
        result = new ArrayList<>();
        if (nums != null && nums.length != 0) {
            used = new boolean[nums.length];
            generatePermutation(nums, 0, new LinkedList<>());
        }
        return result;
    }

    private void generatePermutation(int[] nums, int index, LinkedList<Integer> recent){
        if (index == nums.length) {
            result.add(new LinkedList<>(recent));
            // Or use this :
            // result.add((LinkedList<Integer>) recent.clone());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                recent.addLast(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, recent);
                recent.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args){
        int[] a = {1,2,3};
        List<List<Integer>> result = new Solution().permute2(a);
        for (int i =0; i<result.size(); i++) {
            List<Integer> recent = result.get(i);
            System.out.println(recent);
        }
    }
}
