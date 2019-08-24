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

    private void solve(int i, int[] rows, int n, List<List<String>> result){
        if(i == n) {
            List<String> current = new ArrayList<>();
            for(int p = 0; p < n; p++){
                StringBuilder line = new StringBuilder();
                for(int q = 0; q < n; q++){
                    if(q == rows[p]) line.append("Q");
                    else line.append(".");
                }
                current.add(line.toString());
            }
            result.add(current);
        } else{
            for(int q = 0; q < n; q++){
                if(check(rows, i, q, n)){
                    rows[i] = q;
                    solve(i+1, rows, n, result);
                    // 这里是最重要的一行，找完上一步以后继续回来循环
                    rows[i] = -1;
                }
            }
        }
    }

    private boolean check(int[] rows, int i, int j, int n){
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
        for (List<String> strings : result) {
            for (String string : strings) {
                System.out.println(string + " ");
            }
            System.out.println();
        }
    }
}
