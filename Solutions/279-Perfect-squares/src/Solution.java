import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // Using Lagrange's four-square theorem to simplify

    public int numSquares(int n) {
        while (n % 4 == 0) {
            n = n / 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
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

    public int numSquares1(int n) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(new Pair<>(n, 0));
        visited[n] = true;
        while(!queue.isEmpty()) {
            Pair<Integer, Integer> recent = queue.poll();
            int num = recent.getKey();
            int level = recent.getValue();
            for (int i = 1; i * i <= num; i++) {
                if (num - i * i == 0) {
                    return level + 1;
                }
                if (!visited[num - i * i]) {
                    queue.offer(new Pair<>(num - i * i, level + 1));
                    visited[num - i * i] = true;
                }
            }
        }
        return 0;
    }

    public static void main (String[] args) {
        System.out.println(new Solution().numSquares1(13));
    }
}
