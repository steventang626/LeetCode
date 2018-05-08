import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if(m == 0) return result;
        int n = matrix[0].length;

        int[][] steps = {{0,1},{1,0},{0,-1},{-1,0}};
        int[][] visted = new int[m][n];
        int row = 0, column = 0, status = 0, tem_row, tem_column;

        result.add(matrix[0][0]);
        visted[0][0] = 1;
        for(int i = 2; i <= m*n; i++){
            tem_row = row + steps[status][0];
            tem_column = column + steps[status][1];
            if((tem_column < 0 || tem_column >= n || tem_row < 0 || tem_row >=m) || visted[tem_row][tem_column] != 0){
                status = (status + 1) % 4;
            }
            row = row + steps[status][0];
            column = column + steps[status][1];
            result.add(matrix[row][column]);
            visted[row][column] = 1;
        }
        return result;
    }
    public static void main(String[] args){
        int[][] a = {};
        List<Integer> result = new Solution().spiralOrder(a);
        System.out.println(result);
    }
}
