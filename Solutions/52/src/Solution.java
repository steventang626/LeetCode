import java.util.ArrayList;
import java.util.List;

public class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int[] rows = new int[n];
        for(int i = 0; i<n; i++){
            rows[i] = -1;
        }
        solve(0, rows, n);
        return count;
    }

    public void solve(int i, int[] rows, int n){
        if(i == n) {
            count++;
        } else{
            for(int q = 0; q < n; q++){
                if(check(rows, i, q, n)){
                    rows[i] = q;
                    solve(i+1, rows, n);
                    // 这里是最重要的一行，找完上一步以后继续回来循环
                    rows[i] = -1;
                }
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
        int a = 6;
        int result = new Solution().totalNQueens(a);
        System.out.println(result);
    }
}
