public class Solution {
    public static void main(String[] args) {
        int result = new Solution().climbStairs(3);
        System.out.println(result);
    }

    public int climbStairs4(int n) {
        if (n <= 2) {
            return n;
        }
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    public int climbStairs5(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1, b = 2, c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public int climbStairs3(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs3(n - 1) + climbStairs3(n - 2);
    }

    private int[] cache;
    public int climbStairs2(int n) {
        cache = new int[n + 1];
        return helper(n);
    }

    private int helper(int n) {
        if (n <= 2) {
            return n;
        }
        if (cache[n] == 0) {
            cache[n] = helper(n - 1) + helper(n - 2);
        }
        return cache[n];
    }
}
