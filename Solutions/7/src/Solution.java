import java.lang.Integer;

public class Solution {
    public static int reverse(int x) {
        boolean negative = false;
        if(x < 0) {
            negative = true;
            x = -x;
        }
        long res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (res > java.lang.Integer.MAX_VALUE) return 0;
        if (negative) res = -res;
        return (int)res;
    }

    // 不区分正负数，且提前做终止判断
    public static int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(reverse2(0));
    }
}
