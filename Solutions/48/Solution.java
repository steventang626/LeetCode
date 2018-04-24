public class Solution {
    public void rotate1(int[][] matrix) {
        // 不是原地翻转
        int width = matrix[0].length;
        int height = matrix.length;
        int[][] result = new int[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                result[i][j] = matrix[width - 1 - j][i];
            }
        }
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                matrix[i][j] = result[i][j];
            }
        }
    }
    public void rotate(int[][] matrix) {
        int width = matrix.length;
        for(int i = 0; i < width; i++){
            for(int j = i + 1; j < width; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < width; i++){
            for(int j = 0; j < width / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][width - 1 - j];
                matrix[i][width - 1 - j] = temp;
            }
        }
    }
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new Solution().rotate(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] +  " ");
            }
            System.out.println();
        }
    }
}
