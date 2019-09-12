import java.util.Arrays;

public class Solution {
    private static int factorial(int n) {
        int sum = 1;
        while( n > 0 ) {
            sum = sum * n--;
        }
        return sum;
    }

    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        int big = m + n - 2;
        long result = 1;
        if(m < n){
            while(big >= n) {
                result = result * big--;
            }
            result = result / factorial(m - 1);
        }else{
            while(big >= m) {
                result = result * big--;
            }
            result = result / factorial(n - 1);
        }
        return (int)result;
    }

    // DP
    public int uniquePaths2(int m, int n) {
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            sum[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            sum[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
            }
        }
        return sum[m - 1][n - 1];
    }

    // DP with less space
    public int uniquePaths3(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args){
        int result = new Solution().uniquePaths3(36,7);
        System.out.println(result);
    }
}
