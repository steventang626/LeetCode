public class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;
        if(x == 1.0) return 1.0;
        if(x == -1.0) {
            if(n % 2 == 0) return 1.0;
            else return -1.0;
        }
        if(n == 0) return result;
        else if(n > 0){
            for(int i = 1; i <= n; i++){
                result = result * x;
                if(Math.abs(result) < Double.MIN_VALUE) return 0;
            }
        } else{
            long nn = n;
            long positive_n = -nn;
            for(int i = 1; i <= positive_n; i++){
                result = result * x;
                if(Math.abs(1.0 / result) < Double.MIN_VALUE) return 0;
            }
            result = 1.0 / result;
        }
        return result;
    }
    public static void main(String[] args){
        double x = -1.0;
        int n = 101;
        double result = new Solution().myPow(x,n);
        System.out.println(result);
        long nn = -21473648;
        long positive_n = -(nn);
        System.out.println(positive_n);
    }
}
