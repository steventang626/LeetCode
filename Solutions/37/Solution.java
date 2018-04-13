public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    public boolean solve(char[][] board, int i, int j){
        if(i == 9) return true;
        if(j >= 9) return solve(board,i+1,0);
        if(board[i][j] == '.'){
            for(int k = 1; k<=9; k++){
                board[i][j] = (char)(k + '0');
                if(isValidSudoku(board,i,j)){
                    if(solve(board, i, j+1)) return true;
                }
                // 这一行很重要
                board[i][j] = '.';
            }
        } else {
            return solve(board, i,j+1);
        }
        return false;
    }
    public boolean isValidSudoku(char[][] board,int x, int y){
        char recent = board[x][y];
        for(int j = 0; j < 9; j++){
            if((j != y) && board[x][j] == recent) return false;
        }

        for(int j = 0; j < 9; j++){
            if((j != x) &&board[j][y] == recent) return false;
        }

        int i = (x / 3) * 3;
        int j = (y / 3) * 3;
        int[] validNum = new int[10];
        for(int k = 0; k < 3; k++){
            for(int l= 0; l < 3; l++){
                if(((i+k != x) || (j+l != y)) && board[i+k][j+l] == recent) return false;
            }
        }

        return true;
    }
    public static void main(String[] args){
        char[][] a = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
        new Solution().solveSudoku(a);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
