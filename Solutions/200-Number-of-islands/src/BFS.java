import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int height, width;
    private boolean isValid(int i, int j) {
        return (i >= 0 && i < height && j >= 0 && j < width);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        height = grid.length;
        width = grid[0].length;
        int num = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        int[] point = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = point[0] + directions[k][0];
                            int y = point[1] + directions[k][1];
                            if (isValid(x, y) && grid[x][y] == '1') {
                                queue.offer(new int[]{x, y});
                                grid[x][y] = '0';
                            }
                        }
                    }
                    num++;
                }
            }
        }
        return num;
    }
}
