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

    private Set<List<Integer>> result;
    private boolean[] used;
    public List<List<Integer>> permuteUnique2(int[] nums){
        result = new HashSet<>();
        if (nums != null && nums.length != 0) {
            used = new boolean[nums.length];
            generatePermutation(nums, 0, new LinkedList<>());
        }
        return new ArrayList<>(result);
    }

    private void generatePermutation(int[] nums, int index, LinkedList<Integer> recent){
        if (index == nums.length) {
            if (!result.contains(recent)) {
                result.add(new LinkedList<>(recent));
            }
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

    private List<List<Integer>> result3;
    private boolean[] used3;
    public List<List<Integer>> permuteUnique3(int[] nums){
        result3 = new ArrayList<>();
        if (nums != null && nums.length != 0) {
            used3 = new boolean[nums.length];
            Arrays.sort(nums);
            generatePermutation2(nums, 0, new LinkedList<>());
        }
        return result3;
    }

    private void generatePermutation2(int[] nums, int index, LinkedList<Integer> recent){
        if (index == nums.length) {
            result3.add(new LinkedList<>(recent));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used3[i]) {
                // The pruning in this step is very important, it reduces a lot of work
                if (i > 0 && nums[i] == nums[i - 1] && !used3[i - 1]) {
                    continue;
                }
                recent.addLast(nums[i]);
                used3[i] = true;
                generatePermutation2(nums, index + 1, recent);
                recent.removeLast();
                used3[i] = false;
            }
        }
    }

    public static void main(String[] args){
        int[] a = {1,1,2};
        List<List<Integer>> result = new Solution().permuteUnique3(a);
        for(int i =0; i<result.size(); i++){
            List<Integer> recent = result.get(i);
            System.out.println(recent);
        }
    }
}
