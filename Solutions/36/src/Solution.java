import java.util.HashMap;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            int[] validNum = new int[10];
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    validNum[board[i][j] - '0']++;
                    if(validNum[board[i][j] - '0'] > 1) return false;
                }
            }
        }
        for(int i = 0; i < 9; i++){
            int[] validNum = new int[10];
            for(int j = 0; j < 9; j++){
                if(board[j][i] != '.'){
                    validNum[board[j][i] - '0']++;
                    if(validNum[board[j][i] - '0'] > 1) return false;
                }
            }
        }
        for(int i = 0; i < 9; i=i+3){
            for(int j = 0; j < 9; j=j+3){
                int[] validNum = new int[10];
                for(int k = 0; k < 3; k++){
                    for(int l= 0; l < 3; l++){
                        if(board[i+k][j+l] != '.'){
                            validNum[board[i+k][j+l] - '0']++;
                            if(validNum[board[i+k][j+l] - '0'] > 1) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        char[][] a = {{'.','8','7','6','5','4','.','2','1'},{'2','.','3','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};
        boolean result = new Solution().isValidSudoku(a);
        System.out.println(result);
    }
}
