public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] is = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(is[i][j] == 0 && matrix[i][j] == 0){
                    for(int k = 0; k < m; k++){
                        if(matrix[k][j] != 0){
                            matrix[k][j] = 0;
                            is[k][j] = 1;
                        }
                    }
                    for(int k = 0; k < n; k++){
                        if(matrix[i][k] != 0){
                            matrix[i][k] = 0;
                            is[i][k] = 1;
                        }
                    }

                }
            }
        }
    }
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowIsZero = false;
        boolean columnIsZero = false;
        for(int k = 0; k < m; k++){
            if(matrix[k][0] == 0){
                columnIsZero = true;
                break;
            }
        }
        for(int k = 0; k < n; k++){
            if(matrix[0][k] == 0){
                rowIsZero = true;
                break;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(columnIsZero){
            for(int k = 0; k < m; k++){
                matrix[k][0] = 0;
            }
        }
        if(rowIsZero){
            for(int k = 0; k < n; k++){
                matrix[0][k] = 0;
            }
        }
    }
    public static void main(String[] args){
        int[][] a = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new Solution().setZeroes1(a);
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
