import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> sumSet = new HashSet<>();
        int sum = countSum(n);
        if (sum == 1) return true;
        while (!sumSet.contains(sum)) {
            sumSet.add(sum);
            n = sum;
            sum = countSum(n);
        }
        return sum == 1;
    }

    private int countSum(int n) {
        int result = 0;
        while (n / 10 != 0) {
            result += Math.pow(n%10, 2);
            n = n / 10;
        }
        result += Math.pow(n, 2);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(11));
    }
}
