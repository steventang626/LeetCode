import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        if(n == 1) return "1";
        int num = k - 1;
        List<Integer> notUsed = new ArrayList<>();
        for(int i = 1; i <= n; i++) notUsed.add(i);
        String result = "";
        int quotient;
        int[] factorial = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

        for(int i = n; i >= 2; i--){
            quotient = num / factorial[i - 1];
            num = num % factorial[i - 1];
            result = result + notUsed.get(quotient).toString();
            notUsed.remove(quotient);
        }
        result = result + notUsed.get(0).toString();

        return result;
    }
    public static void main(String[] args){
        String result = new Solution().getPermutation(4, 9);
        System.out.println(result);
    }
}
