import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution {
    private Map<Integer, Set<Integer>> xMap = new HashMap<>();
    private Map<Integer, Set<Integer>> yMap = new HashMap<>();
    // BFS, Time O(n), Space O(n)
    public int removeStones(int[][] stones) {
        for (int i = 0; i < stones.length; i++) {
            Set<Integer> xSet = xMap.getOrDefault(stones[i][0], new HashSet<>());
            xSet.add(i);
            xMap.put(stones[i][0], xSet);
            Set<Integer> ySet = yMap.getOrDefault(stones[i][1], new HashSet<>());
            ySet.add(i);
            yMap.put(stones[i][1], ySet);
        }
        int connectedArea = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < stones.length; i++) {
            if (!visited.contains(i)) {
                queue.add(i);
                visited.add(i);
                while (!queue.isEmpty()) {
                    int visit = queue.poll();
                    Set<Integer> xSet = xMap.get(stones[visit][0]);
                    if (xSet != null) {
                        queue.addAll(xSet);
                        visited.addAll(xSet);
                        xSet.clear();
                    }
                    Set<Integer> ySet = yMap.get(stones[visit][1]);
                    if (ySet != null) {
                        queue.addAll(ySet);
                        visited.addAll(ySet);
                        ySet.clear();
                    }
                }
                connectedArea++;
            }
        }
        return stones.length - connectedArea;
    }

    // DFS
    public int removeStones2(int[][] stones) {
        for (int i = 0; i < stones.length; i++) {
            Set<Integer> xSet = xMap.getOrDefault(stones[i][0], new HashSet<>());
            xSet.add(i);
            xMap.put(stones[i][0], xSet);
            Set<Integer> ySet = yMap.getOrDefault(stones[i][1], new HashSet<>());
            ySet.add(i);
            yMap.put(stones[i][1], ySet);
        }
        int connectedArea = 0;
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < stones.length; i++) {
            if (!visited.contains(i)) {
                stack.add(i);
                visited.add(i);
                while (!stack.isEmpty()) {
                    int visit = stack.pop();
                    Set<Integer> xSet = xMap.get(stones[visit][0]);
                    if (xSet != null) {
                        stack.addAll(xSet);
                        visited.addAll(xSet);
                        xSet.clear();
                    }
                    Set<Integer> ySet = yMap.get(stones[visit][1]);
                    if (ySet != null) {
                        stack.addAll(ySet);
                        visited.addAll(ySet);
                        ySet.clear();
                    }
                }
                connectedArea++;
            }
        }
        return stones.length - connectedArea;
    }

    public static void main(String[] args) {
        int[][] stones = {{0,1}, {1,0}};
        System.out.println(new Solution().removeStones2(stones));
    }
}
