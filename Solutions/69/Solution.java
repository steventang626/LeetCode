public class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        int max = (int)Math.sqrt(Integer.MAX_VALUE);
        int small = 1;
        int big = Math.min(x, max);
        int mid = 0;
        while(small < big){
            mid = small + (big - small) / 2;
            if(mid * mid == x){
                return mid;
            }else if(mid * mid > x){
                big = mid - 1;
            }else{
                small = mid;
                if(big - small == 1) {
                    if(big * big <= x) return big;
                    else return small;
                }
            }
        }
        return small;
    }
    public static void main(String[] args){
        int x = 5;
        int result = new Solution().mySqrt(x);
        System.out.println(result);
    }
}
