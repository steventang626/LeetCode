import java.util.HashSet;
import java.util.Set;

public class Solution {
    private int[][] globalGrid;
    private Set<Integer> island;

    private void dfs(int i, int j, int startX, int startY) {
        if (i >= 0 && i < globalGrid.length && j >= 0 && j < globalGrid[0].length && globalGrid[i][j] == 1) {
            globalGrid[i][j] = 0;
            island.add((i - startX) * 2 * globalGrid[0].length + (j - startY));
            dfs(i - 1, j, startX, startY);
            dfs(i + 1, j, startX, startY);
            dfs(i, j - 1, startX, startY);
            dfs(i, j + 1, startX, startY);
        }
    }

    public int numDistinctIslands(int[][] grid) {
        globalGrid = grid;
        Set<Set<Integer>> islands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    island = new HashSet<>();
                    dfs(i, j, i, j);
                    islands.add(island);
                }
            }
        }
        return islands.size();
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}};
        System.out.println(new Solution().numDistinctIslands(grid));
    }
}
