public class Solution {
    public boolean exist(char[][] board, String word) {
        int length = word.length();
        int m = board.length;
        int n = board[0].length;
        //int length_now = 0;
        if(length == 0) return false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(length == 1) return true;
                    else{
                        int[][] occupied = new int[m][n];
                        //length_now = 1;
                        occupied[i][j] = 1;
                        if(find(i,j, board,word.substring(1),occupied)) return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean find(int i, int j,char[][] board, String word, int[][] occupied) {
        int m = board.length;
        int n = board[0].length;
        int length = word.length();
        if (i + 1 < m && occupied[i+1][j] == 0 && board[i + 1][j] == word.charAt(0)) {
            occupied[i + 1][j] = 1;
            if (length == 1) {
                return true;
            } else if (find(i + 1, j, board, word.substring(1),occupied)) {
                return true;
            }
            occupied[i + 1][j] = 0;
        }
        if(i - 1 >= 0 && occupied[i-1][j] == 0 && board[i - 1][j] == word.charAt(0)){
            occupied[i - 1][j] = 1;
            if(length == 1) return true;
            else if(find(i - 1, j, board, word.substring(1),occupied)) return true;
            occupied[i - 1][j] = 0;
        }
        if(j + 1 < n && occupied[i][j + 1] == 0 && board[i][j + 1] == word.charAt(0)){
            occupied[i][j + 1] = 1;
            if(length == 1) return true;
            else if(find(i, j + 1, board, word.substring(1),occupied)) return true;
            occupied[i][j + 1] = 0;
        }
        if(j - 1 >= 0 && occupied[i][j - 1] == 0 && board[i][j - 1] == word.charAt(0)){
            occupied[i][j - 1] = 1;
            if(length == 1) return true;
            else if(find(i, j - 1, board, word.substring(1),occupied)) return true;
            occupied[i][j - 1] = 0;
        }
        return false;
    }

    private int m;
    private int n;
    private boolean[][] occupied;
    private int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean exist2(char[][] board, String word) {
        int length = word.length();
        if (length == 0) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        occupied = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (wordSearch(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean wordSearch(char[][] board, String word, int index, int x, int y) {
        if (index == word.length() - 1) {
            return word.charAt(index) == board[x][y];
        }
        if (word.charAt(index) == board[x][y]) {
            occupied[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = x + direction[i][0];
                int nextY = y + direction[i][1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !occupied[nextX][nextY]) {
                    if (wordSearch(board, word, index + 1, nextX, nextY)) {
                        return true;
                    }
                }
            }
            occupied[x][y] = false;
        }
        return false;
    }

    public static void main(String[] args){
        char[][] a = {{'A','B','C','E'}, {'S','E','C','S'}, {'A','D','E','E'}};
        System.out.print(new Solution().exist2(a, "ECEES"));
    }
}
