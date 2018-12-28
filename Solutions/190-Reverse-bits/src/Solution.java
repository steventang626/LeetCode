public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        int mask = 1;
        for(int i = 0; i < 32; i++) {
            if((mask & n) != 0) {
                result += 1 << (32 - i - 1);
            }
            mask <<= 1;
        }
        return result;
    }

    public int reverseBits2(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            if((n & 1) == 0) {
                result = result << 1;
            } else {
                result = (result << 1) + 1;
            }
            n = n >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits2(43261596));
    }
}
