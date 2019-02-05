import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> result;
    private boolean[] used;

    /**
     * The main function for testing.
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        List<List<Integer>> result = new Solution().permute2(a);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> recent = result.get(i);
            System.out.println(recent);
        }
    }

    /**
     * The first version of permute.
     */
    public List<List<Integer>> permute(final int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        List<List<Integer>> listOne = new ArrayList<>();
        List<Integer> listTwo = new ArrayList<>();
        listTwo.add(nums[0]);
        listOne.add(listTwo);
        if (nums.length == 1) {
            return listOne;
        }
        List<List<Integer>> recentResult = permute(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> resultPermute = new ArrayList<>();
        for (int i = 0; i < recentResult.size(); i++) {
            List<Integer> recentList = recentResult.get(i);
            for (int j = 0; j <= recentList.size(); j++) {
                List<Integer> newList = new ArrayList<>(recentList);
                newList.add(j, nums[0]);
                resultPermute.add(newList);
            }
        }
        return resultPermute;
    }

    /**
     * The second version using recursive ways.
     */
    public List<List<Integer>> permute2(int[] nums) {
        result = new ArrayList<>();
        if (nums != null && nums.length != 0) {
            used = new boolean[nums.length];
            generatePermutation(nums, 0, new LinkedList<>());
        }
        return result;
    }

    private void generatePermutation(int[] nums, int index, List<Integer> recent) {
        if (index == nums.length) {
            result.add(new LinkedList<>(recent));
            // Or use this :
            // result.add((LinkedList<Integer>) recent.clone());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                recent.add(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, recent);
                recent.remove(recent.size() - 1);
                used[i] = false;
            }
        }
    }
}
