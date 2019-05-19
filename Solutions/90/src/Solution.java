import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nullArray = new ArrayList<>();
        result.add(nullArray);
        int length = nums.length;
        if(length == 0) return result;
        for(int i = 1; i <= length; i++){
            List<List<Integer>> sub = combine(length, i);
            for(int j = 0; j < sub.size(); j++){
                List<Integer> original = sub.get(j);
                List<Integer> newArray = new ArrayList<>();
                for(int l = 0; l < i; l++){
                    newArray.add(nums[original.get(l) - 1]);
                }
                if(!result.contains(newArray)){
                    result.add(newArray);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(k == 1){
            for(int i = 1; i <= n; i++){
                List<Integer> newArray = new ArrayList<>();
                newArray.add(i);
                result.add(newArray);
            }
            return result;
        }
        for(int i = 0; i < n - k + 1; i++){
            List<List<Integer>> r = combine(n - i - 1, k - 1);
            for(int j = 0; j < r.size(); j++){
                List<Integer> original = r.get(j);
                List<Integer> newArray = new ArrayList<>();
                newArray.add(i + 1);
                for(int l = 0; l < k - 1; l++){
                    newArray.add(original.get(l) + i + 1);
                }
                result.add(newArray);
            }
        }
        return result;
    }

    private Set<List<Integer>> subsetResult;
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        subsetResult = new HashSet<>();
        Arrays.sort(nums);
        generateSubset(nums, 0, new ArrayList<>());
        return new ArrayList<>(subsetResult);
    }

    private void generateSubset(int[] nums, int start, List<Integer> recentResult) {
        if (start == nums.length) {
            if (!subsetResult.contains(recentResult)) {
                subsetResult.add(new ArrayList<>(recentResult));
            }
            return;
        }
        generateSubset(nums, start + 1, recentResult);
        recentResult.add(nums[start]);
        generateSubset(nums, start + 1, recentResult);
        recentResult.remove(recentResult.size() - 1);
    }

    private List<List<Integer>> subsetResultList;
    public List<List<Integer>> subsetsWithDup3(int[] nums) {
        subsetResultList = new ArrayList<>();
        Arrays.sort(nums);
        generateSubset2(nums, 0, new ArrayList<>());
        return subsetResultList;
    }

    private void generateSubset2(int[] nums, int start, List<Integer> recentResult) {
        if (start <= nums.length) {
            subsetResultList.add(recentResult);
        }
        while (start < nums.length) {
            recentResult.add(nums[start]);
            generateSubset2(nums, start + 1, recentResult);
            recentResult.remove(recentResult.size() - 1);
            start++;
            while (start < nums.length && nums[start] == nums[start - 1]) {
                start++;
            }
        }
    }

    public static void main(String[] args){
        int[] a = {1, 2, 2};
        List<List<Integer>> result = new Solution().subsetsWithDup3(a);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
