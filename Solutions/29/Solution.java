public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || ((dividend == Integer.MIN_VALUE) && (divisor == -1))) return Integer.MAX_VALUE;
        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;
        long m = Math.abs((long)dividend);
        long n = Math.abs((long)divisor);
        boolean isNegative = false;
        long result = 0;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) isNegative = true;
        while(m >= n){
            long t = n, p = 1;
            while(m >= (t<<1)){
                t = t<<1;
                p = p<<1;
            }
            result = result + p;
            m = m - t;
        }
        if(isNegative) return (int)-result;
        else return (int)result;
    }
    public static void main(String[] args){
        int result = new Solution().divide(-2147483648,2);
        System.out.println(result);
    }
}
