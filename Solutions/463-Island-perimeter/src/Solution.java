/**
 * @author Yuhan
 */
public class Solution {
    private final int DIRECTION = 4;

    /**
     * Time O(N)
     */
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += calculatePerimeter(grid, i, j);
                }
            }
        }
        return result;
    }

    private int calculatePerimeter(int[][] grid, int i, int j) {
        int count = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int k = 0; k < DIRECTION; k++) {
            int x = i + directions[k][0];
            int y = j + directions[k][1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                count++;
            }
        }
        return DIRECTION - count;
    }

    public int islandPerimeter2(int[][] grid) {
        int result = 0;
        int count, x, y;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    for (int k = 0; k < DIRECTION; k++) {
                        x = i + directions[k][0];
                        y = j + directions[k][1];
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                            count++;
                        }
                    }
                    result += DIRECTION - count;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0},
                        {1, 1, 1, 0},
                        {0, 1, 0, 0},
                        {1, 1, 0, 0}};
        System.out.println(new Solution().islandPerimeter2(grid));
    }
}
