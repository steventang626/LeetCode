import java.util.HashSet;

class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;
    private boolean[][] visited;
    private boolean isSurrounded = true;
    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;
        if (m <= 2 || n <= 2) {
            return;
        }
        visited = new boolean[m][n];
        HashSet<Pair> oSet = new HashSet<>();
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    isSurrounded = true;
                    dfs(board, i, j, oSet);
                    if (isSurrounded) {
                        for (Pair pair : oSet) {
                            board[pair.x][pair.y] = 'X';
                        }
                    }
                    oSet.clear();
                }
            }
        }
    }

    void dfs(char[][] board, int x, int y, HashSet<Pair> oSet) {
        visited[x][y] = true;
        oSet.add(new Pair(x, y));
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX == 0 || newX == m - 1 || newY == 0 || newY == n - 1) {
                if (board[newX][newY] == 'O') {
                    isSurrounded = false;
                }
            } else if (board[newX][newY] == 'O' && !visited[newX][newY]) {
                dfs(board, newX, newY, oSet);
            }
        }
    }

    public void solve2(char[][] board) {
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;
        if (m <= 2 || n <= 2) {
            return;
        }
        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    dfs2(board, i, j);
                }
            }
        }
        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '$') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs2(char[][] board, int x, int y) {
        board[x][y] = '$';
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX >= 0 && newX <= m - 1 && newY >= 0 && newY <= n - 1 && board[newX][newY] == 'O') {
                dfs2(board, newX, newY);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};
        new Solution().solve2(board);
        for (char[] chars : board) {
            for (char ch : chars) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
