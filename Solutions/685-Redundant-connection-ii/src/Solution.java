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
    // Union-find, Time O(n)
    public int[] findRedundantDirectedConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length + 1);
        int[] root = new int[edges.length + 1];
        int[] firstEdge = new int[2];
        int[] secondEdge = new int[2];
        for (int[] edge : edges) {
            int start = edge[0], end = edge[1];
            if (root[end] == 0) {
                root[end] = start;
            } else {
                firstEdge[0] = root[end];
                firstEdge[1] = end;
                secondEdge = edge;
                break;
            }
        }
        for (int[] edge : edges) {
            if (edge == secondEdge) {
                continue;
            }
            int start = edge[0], end = edge[1];
            if (!dsu.union(start, end)) {
                if (firstEdge[0] == 0 && firstEdge[1] == 0) {
                    return edge;
                } else {
                    return firstEdge;
                }
            }
        }
        return secondEdge;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        int[] result = new Solution().findRedundantDirectedConnection(edges);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
