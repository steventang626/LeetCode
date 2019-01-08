public class Solution {
    public int hammingDistance(int x, int y) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            int digit = 1 << i;
            if(((digit & x) == 0) != ((digit & y) == 0)) result++;
        }
        return result;
    }

    public int hammingDistance2(int x, int y) {
        int result = 0;
        int mask = 1;
        for(int i = 0; i < 32; i++) {
            if(((mask & x) == 0) != ((mask & y) == 0)) result++;
            mask <<= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance2(1, 4));
    }
}
