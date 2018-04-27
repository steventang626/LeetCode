import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] rows = new int[n];
        for(int i = 0; i<n; i++){
            rows[i] = -1;
        }
        solve(0, rows, n, result);
        return result;
    }

    public void solve(int i, int[] rows, int n, List<List<String>> result){
        if(i == n) {
            List<String> current = new ArrayList<>();
            for(int p = 0; p < n; p++){
                String line = "";
                for(int q = 0; q < n; q++){
                    if(q == rows[p]) line += "Q";
                    else line += ".";
                }
                current.add(line);
            }
            result.add(current);
        }

        for(int q = 0; q < n; q++){
            if(check(rows, i, q, n)){
                rows[i] = q;
                solve(i+1, rows, n, result);
                // 这里是最重要的一行，找完上一步以后继续回来循环
                rows[i] = -1;
            }
        }
    }

    public boolean check(int[] rows, int i, int j, int n){
        for(int k = 0; k < i; k++){
            if((rows[k] == j) || (Math.abs(i - k) == Math.abs(j - rows[k]))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int a = 4;
        List<List<String>> result = new Solution().solveNQueens(a);
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.println(result.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
