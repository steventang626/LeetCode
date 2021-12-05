public class Solution {
    public static void main(String[] args) {
        int[][] a = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int result = new Solution().minPathSum(a);
        System.out.println(result);
    }

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        result[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            result[0][i] = result[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            result[i][0] = result[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j];
            }
        }
        return result[m - 1][n - 1];
    }

    private int[][] cache;
    public int minPathSum2(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cache[i][j] = -1;
            }
        }
        return helper(grid, m - 1, n - 1);
    }

    private int helper(int[][] grid, int m, int n) {
        if (m == 0 && n == 0) {
            cache[m][n] = grid[m][n];
            return cache[m][n];
        }
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (cache[m][n] != -1) {
            return cache[m][n];
        }
        cache[m][n] = Math.min(helper(grid, m, n - 1),
                helper(grid, m - 1, n)) + grid[m][n];
        return cache[m][n];
    }
}
