import java.util.ArrayList;
import java.util.List;

public class Solution {
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
        List<List<Integer>> result = new Solution().combine(5,2);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
