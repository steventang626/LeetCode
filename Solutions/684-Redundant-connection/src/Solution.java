import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class DSU {
    private int[] root;
    private int[] rank;
    DSU(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    int find(int node) {
        if (root[node] != node) {
            root[node] = find(root[node]);
        }
        return root[node];
    }

    boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB)  {
            return false;
        } else if (rank[rootA] < rank[rootB]) {
            root[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            root[rootB] = rootA;
        } else {
            root[rootB] = rootA;
            rank[rootA]++;
        }
        return true;
    }
}

public class Solution {
    private Set<Integer> visited;
    // DFS, Time O(n^2)
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        visited = new HashSet<>();
        for (int[] edge : edges) {
            visited.clear();
            int start = edge[0], end = edge[1];
            if (graph.containsKey(start) && graph.containsKey(end) && dfs(graph, start, end)) {
                return edge;
            }
            List<Integer> listStart = graph.getOrDefault(start, new ArrayList<>());
            listStart.add(end);
            graph.put(start, listStart);
            List<Integer> listEnd = graph.getOrDefault(end, new ArrayList<>());
            listEnd.add(start);
            graph.put(end, listEnd);
        }
        return new int[2];
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int start, int end) {
        if (!visited.contains(start)) {
            visited.add(start);
            if (start == end) {
                return true;
            }
            for(int neigh : graph.get(start)) {
                if (dfs(graph, neigh, end)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Union-find, Time O(n)
    public int[] findRedundantConnection2(int[][] edges) {
        final int MAX_SIZE = 1001;
        DSU dsu = new DSU(MAX_SIZE);
        for (int[] edge : edges) {
            int start = edge[0], end = edge[1];
            if (!dsu.union(start, end)) {
                return edge;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
	    int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
	    int[] result = new Solution().findRedundantConnection2(edges);
	    System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
