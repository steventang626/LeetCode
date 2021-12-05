import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    private int height, width;
    private boolean[][] isVisited;
    private char[][] globalGrid;

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}};
        System.out.println(new Solution().numIslands3(grid));
    }

    public int numIslands(char[][] grid) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int num = 0;
        height = grid.length;
        if (height == 0) {
            return num;
        }
        width = grid[0].length;
        isVisited = new boolean[height][width];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    queue.add(new Pair<>(i, j));
                    isVisited[i][j] = true;
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> point = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = point.getKey() + directions[k][0];
                            int y = point.getValue() + directions[k][1];
                            if (isValid(x, y) && grid[x][y] == '1') {
                                queue.add(new Pair<>(x, y));
                                isVisited[x][y] = true;
                            }
                        }
                    }
                    num++;
                }
            }
        }
        return num;
    }

    private boolean isValid(int i, int j) {
        return (i >= 0 && i < height && j >= 0 && j < width && !isVisited[i][j]);
    }

    public int numIslands2(char[][] grid) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int num = 0;
        height = grid.length;
        if (height == 0) {
            return num;
        }
        width = grid[0].length;
        isVisited = new boolean[height][width];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    queue.add(new int[]{i, j});
                    isVisited[i][j] = true;
                    while (!queue.isEmpty()) {
                        System.out.print(queue.size());
                        for (int[] x : queue) {
                            System.out.print(" (" + x[0] + ", " + x[1] + ") ");
                        }
                        System.out.println();
                        int[] point = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = point[0] + directions[k][0];
                            int y = point[1] + directions[k][1];
                            if (isValid(x, y) && grid[x][y] == '1') {
                                queue.add(new int[]{x, y});
                                isVisited[x][y] = true;
                            }
                        }
                    }
                    num++;
                }
            }
        }
        return num;
    }

    // DFS
    public int numIslands3(char[][] grid) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int num = 0;
        height = grid.length;
        if (height == 0) {
            return num;
        }
        width = grid[0].length;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    stack.push(new int[]{i, j});
                    grid[i][j] = '0';
                    while (!stack.isEmpty()) {
                        System.out.print(stack.size());
                        for (int[] x : stack) {
                            System.out.print(" (" + x[0] + ", " + x[1] + ") ");
                        }
                        System.out.println();
                        int[] point = stack.pop();
                        for (int k = 0; k < 4; k++) {
                            int x = point[0] + directions[k][0];
                            int y = point[1] + directions[k][1];
                            if ((x >= 0 && x < height && y >= 0 && y < width) && grid[x][y] == '1') {
                                stack.push(new int[]{x, y});
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

    public int numIslands4(char[][] grid) {
        globalGrid = grid;
        int num = 0;
        height = grid.length;
        if (height == 0) {
            return num;
        }
        width = grid[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (globalGrid[i][j] == '1') {
                    dfs(i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void dfs(int i, int j) {
        globalGrid[i][j] = '0';
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int k = 0; k < 4; k++) {
            int x = i + directions[k][0];
            int y = j + directions[k][1];
            if ((x >= 0 && x < height && y >= 0 && y < width) && globalGrid[x][y] == '1') {
                dfs(x, y);
            }
        }
    }

    // Faster
    private void dfs2(int i, int j) {
        if (i < 0 || i > height - 1 || j < 0 || j > width - 1 || globalGrid[i][j] == '0') {
            return;
        }
        globalGrid[i][j] = '0';
        dfs2(i - 1, j);
        dfs2(i + 1, j);
        dfs2(i, j - 1);
        dfs2(i, j + 1);
    }
}
