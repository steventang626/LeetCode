import java.util.HashMap;

public class Solution {

    // Time O(n^2)
    // Space O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : C) {
            for (int j : D) {
                int sum = i + j;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }
        int result = 0;
        for (int i : A) {
            for (int j : B) {
                int sum = i + j;
                if (map.containsKey(-sum)) {
                    result += map.get(-sum);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-1, -2};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        System.out.println(new Solution().fourSumCount(A, B, C, D));
    }
}
