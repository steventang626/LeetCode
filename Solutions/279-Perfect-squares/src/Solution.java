import javafx.util.Pair;

import java.util.LinkedList;

public class Solution {
    // Using Lagrange's four-square theorem to simplify
    public int numSquares(int n) {
        while (n % 4 == 0) n = n / 4;
        if (n % 8 == 7) return 4;
        for (int i = 0; i * i <= n; i++) {
            int j = (int) Math.sqrt(n - i * i);
            if (i * i + j * j == n) {
                if (i == 0 || j == 0) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return 3;
    }

    // Using queue and BFS
    public int numSquares2(int n) {
        while (n % 4 == 0) n = n / 4;
        int result = 0;
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        int[] visited = new int[n];
        queue.addLast(new Pair<>(n, 0));
        while(!queue.isEmpty()) {
            Pair<Integer, Integer> recent = queue.removeFirst();
            int num = recent.getKey();
            int level = recent.getValue();
            for(int i = 1; i * i <= num; i++) {
                if (num - i * i == 0) return level + 1;
                if (visited[num - i * i] == 0) {
                    queue.addLast(new Pair<>(num - i * i, level + 1));
                    visited[num - i * i] = 1;
                }
            }
        }
        return result;
    }

    public static void main (String[] args) {
        System.out.println(new Solution().numSquares(13));
    }
}
