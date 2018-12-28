import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Too slow, cannot pass OJ
    public int largestPalindrome(int n) {
        long min = (int) Math.pow(10, n - 1);
        long max = (int) Math.pow(10, n) - 1;
        long a, b;
        long result = 0, product;
        for(a = max; a >= min; a--) {
            for(b = a; b >= min; b--) {
                product = a * b;
                if(product < result) {
                    b = min - 1;
                    break;
                }
                if(isPalindrome(product)) result = product;
            }
        }
        System.out.println(result);
        return (int) (result % 1337);
    }

    public boolean isPalindrome(long n) {
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add((int)(n % 10));
            n = n / 10;
        }
        int length = list.size();
        for(int i = 0; i <= length / 2; i++) {
            if(!list.get(i).equals(list.get(length - i - 1))) return false;
        }
        return true;
    }

    public int largestPalindrome2(int n) {
        if(n == 1) return 9;
        int min = (int) Math.pow(10, n - 1);
        int max = (int) Math.pow(10, n) - 1;
        long product;
        for(int a = max - 1; a >= min; a--) {
            product = Long.valueOf(a + new StringBuilder().append(a).reverse().toString());
            for(long b = max; b * b >= product; b--) {
                if(product % b == 0) {
                    return (int) (product % 1337);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestPalindrome2(8));
        System.out.println(new Solution().isPalindrome(1233333333333321L));
    }
}
