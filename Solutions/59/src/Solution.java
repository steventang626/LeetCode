public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int row = 0, column = 0, status = 0, tem_row, tem_column;
        int[][] steps = {{0,1},{1,0},{0,-1},{-1,0}};
        result[0][0] = 1;
        for(int i = 2; i <= n*n; i++){
            tem_row = row + steps[status][0];
            tem_column = column + steps[status][1];
            if((tem_column < 0 || tem_column >= n || tem_row < 0 || tem_row >=n) || result[tem_row][tem_column] != 0){
                status = (status + 1) % 4;
            }
            row = row + steps[status][0];
            column = column + steps[status][1];
            result[row][column] = i;
        }
        return result;
    }
    public static void main(String[] args){
        int a = 4;
        int[][]  result = new Solution().generateMatrix(a);
        for(int i = 0; i < result.length; i++){
            for (int r:result[i]) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }
}
