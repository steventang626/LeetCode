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
    public static void main(String[] args){
        int result = new Solution().uniquePaths(7,36);
        System.out.println(result);
    }
}
