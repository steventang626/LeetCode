public class Solution {
    public int hammingWeight(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            int digit = 1 << i;
            if((digit & n) != 0) {
                result++;
            }
        }
        return result;
    }

    public int hammingWeight2(int n) {
        int result = 0;
        int mask = 1;
        for(int i = 0; i < 32; i++) {
            if((mask & n) != 0) {
                result++;
            }
            mask <<= 1;
        }
        return result;
    }

    public int hammingWeight3(int n) {
        int result = 0;
        while(n != 0) {
            result++;
            n &= (n -1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight3(-3));
    }
}
