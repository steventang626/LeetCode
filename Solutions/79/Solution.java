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
        if(i + 1 < m && occupied[i+1][j] == 0 && board[i + 1][j] == word.charAt(0)){
            occupied[i + 1][j] = 1;
            if(length == 1) return true;
            else if(find(i + 1, j, board, word.substring(1),occupied)) return true;
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
    public static void main(String[] args){
        char[][] a = {{'A','B','C','E'},{'S','E','C','S'},{'A','D','E','E'}};
        System.out.print(new Solution().exist(a, "ECEES"));
    }
}
