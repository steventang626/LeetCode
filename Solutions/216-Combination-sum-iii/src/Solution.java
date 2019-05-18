import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> combinationSumResult;
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSumResult = new ArrayList<>();
        if (k > n || k * 9 < n) {
            return combinationSumResult;
        }
        generateCombinationSum(n, 1, new ArrayList<>(), k);
        return combinationSumResult;
    }

    private void generateCombinationSum(int target, int start, List<Integer> recentResult, int size) {
        if (target == 0 && recentResult.size() == size) {
            combinationSumResult.add(new ArrayList<>(recentResult));
            return;
        }
        if (recentResult.size() > size) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            // Pruning
            if (i > target) {
                return;
            }
            recentResult.add(i);
            generateCombinationSum(target - i, i + 1, recentResult, size);
            recentResult.remove(recentResult.size() - 1);
        }
    }

    public static void main(String[] args){
        int target = 15;
        List<List<Integer>> result = new Solution().combinationSum3(3, target);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> r = result.get(i);
            for (int j = 0; j<r.size();j++) {
                System.out.print(r.get(j) + " ");
            }
            System.out.println();
        }
    }
}