import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
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
                result.add(newArray);
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

    public static void main(String[] args){
        int[] a = {1,2,3};
        List<List<Integer>> result = new Solution().subsets(a);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
