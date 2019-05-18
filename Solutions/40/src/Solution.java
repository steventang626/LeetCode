import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length == 0) return result;
        Arrays.sort(candidates);
        for(int i = 0; i< candidates.length; i++){
            if(target == candidates[i]){
                List<Integer> a = new ArrayList<>();
                a.add(target);
                if(!result.contains(a)){
                    result.add(a);
                }
                break;
            } else if(target < candidates[i]){
                break;
            } else if(target - candidates[i] < candidates[0]){
                //continue;
            } else{
                int[] candidates_i = new int[candidates.length-1];
                for(int start_1 = 0; start_1<i;start_1++){
                    candidates_i[start_1] = candidates[start_1];
                }
                for(int start_2 = i+1; start_2<candidates.length;start_2++){
                    candidates_i[start_2-1] = candidates[start_2];
                }
                List<List<Integer>> recent_result = combinationSum2_1(candidates_i, target - candidates[i]);
                if(recent_result.size() == 0){
                    //continue;
                } else{
                    for(int j = 0; j<recent_result.size();j++){
                        List<Integer> b = recent_result.get(j);
                        int k;
                        for(k = 0; k<b.size(); k++){
                            if(candidates[i] <= b.get(k)){
                                b.add(k,candidates[i]);
                                break;
                            }
                        }
                        if(k == b.size()){
                            b.add(candidates[i]);
                        }
                        //b.add(candidates[i]);
                        //Collections.sort(b);
                        if(!result.contains(b)){
                            result.add(b);
                        }
                    }
                }
            }
        }
        return result;
    }
    public List<List<Integer>> combinationSum2_1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length == 0) return result;
        //Arrays.sort(candidates);
        for(int i = 0; i< candidates.length; i++){
            if(target == candidates[i]){
                List<Integer> a = new ArrayList<>();
                a.add(target);
                if(!result.contains(a)){
                    result.add(a);
                }
                break;
            } else if(target < candidates[i]){
                break;
            } else if(target - candidates[i] < candidates[0]){
                //continue;
            } else{
                int[] candidates_i = new int[candidates.length-1];
                for(int start_1 = 0; start_1<i;start_1++){
                    candidates_i[start_1] = candidates[start_1];
                }
                for(int start_2 = i+1; start_2<candidates.length;start_2++){
                    candidates_i[start_2-1] = candidates[start_2];
                }
                List<List<Integer>> recent_result = combinationSum2(candidates_i, target - candidates[i]);
                if(recent_result.size() == 0){
                    //continue;
                } else{
                    for(int j = 0; j<recent_result.size();j++){
                        List<Integer> b = recent_result.get(j);
                        int k;
                        for(k = 0; k<b.size(); k++){
                            if(candidates[i] <= b.get(k)){
                                b.add(k,candidates[i]);
                                break;
                            }
                        }
                        if(k == b.size()){
                            b.add(candidates[i]);
                        }
                        //b.add(candidates[i]);
                        //Collections.sort(b);
                        if(!result.contains(b)){
                            result.add(b);
                        }
                    }
                }
            }
        }
        return result;
    }

    private List<List<Integer>> combinationSumResult;
    public List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
        combinationSumResult = new ArrayList<>();
        if (candidates.length <= 0 || target <= 0) {
            return combinationSumResult;
        }
        Arrays.sort(candidates);
        generateCombinationSum(candidates, target, 0, new ArrayList<>());
        return combinationSumResult;
    }

    private void generateCombinationSum(int[] candidates, int target, int start, List<Integer> recentResult) {
        if (target == 0) {
            combinationSumResult.add(new ArrayList<>(recentResult));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // Pruning
            if (candidates[i] > target) {
                return;
            }
            // Avoid duplicate results
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            recentResult.add(candidates[i]);
            generateCombinationSum(candidates, target - candidates[i], i + 1, recentResult);
            recentResult.remove(recentResult.size() - 1);
        }
    }

    public static void main(String[] args){
        int[] a = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> result = new Solution().combinationSum2_2(a,target);
        //System.out.print(result.size());
        for(int i = 0; i<result.size();i++){
            List<Integer> r = result.get(i);
            for(int j = 0; j<r.size();j++){
                System.out.print(r.get(j)+" ");
            }
            System.out.println();
        }
    }
}
