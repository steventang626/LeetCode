import java.util.Arrays;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int y = matrix.length;
        if(y == 0) return 0;
        int x = matrix[0].length;
        int[][] left = new int[y][x];
        int[][] up = new int[y][x];
        int[][] result = new int[y][x];
        if(matrix[0][0] == '1'){
            result[0][0] = 1;
        }
        for(int i = 0; i < y; i++){
            if(matrix[i][0] == '1'){
                left[i][0] = 1;
            }
            for(int j = 1; j < x; j++){
                if(matrix[i][j] == '1'){
                    if(matrix[i][j - 1] == '0'){
                        left[i][j] = 1;
                    }else{
                        left[i][j] = left[i][j - 1] + 1;
                    }
                }
            }
        }
        for(int i = 0; i < x; i++){
            if(matrix[0][i] == '1'){
                up[0][i] = 1;
            }
            for(int j = 1; j < y; j++){
                if(matrix[j][i] == '1'){
                    if(matrix[j - 1][i] == '0'){
                        up[j][i] = 1;
                    }else{
                        up[j][i] = up[j - 1][i] + 1;
                    }
                }
            }
        }
        for(int i = 1; i < y; i++){
            result[i][0] = Math.max(result[i - 1][0], up[i][0]);
        }
        for(int i = 1; i < x; i++){
            result[0][i] = Math.max(result[0][i - 1], left[0][i]);
        }
        for(int i = 1; i < y; i++){
            for(int j = 1; j < x; j++){
                if(matrix[i][j] == '1'){
                    if(matrix[i][j - 1] == '0' && matrix[i - 1][j] == '0'){
                        result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                    }else if(matrix[i][j - 1] == '0' && matrix[i - 1][j] == '1'){
                        result[i][j] = Math.max(up[i][j], Math.max(result[i - 1][j], result[i][j - 1]));
                    }else if(matrix[i][j - 1] == '1' && matrix[i - 1][j] == '0'){
                        result[i][j] = Math.max(left[i][j], Math.max(result[i - 1][j], result[i][j - 1]));
                    }else{
                        int xmax = left[i][j];
                        int xmaxy = up[i][j];
                        int max = up[i][j];
                        for(int k = 1; k < xmax; k++){
                            if(up[i][j - k] < xmaxy) xmaxy = up[i][j - k];
                            max = Math.max(max, (k + 1) * xmaxy);
                        }
                        result[i][j] = Math.max(max, Math.max(result[i - 1][j], result[i][j - 1]));
                    }
                }else{
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
//        for(int i = 0; i < y; i++){
//            for(int j = 0; j < x; j++){
//                System.out.print(result[i][j] + " ");
//            }
//            System.out.println();
//        }
        return result[y - 1][x - 1];
    }

    public int maximalRectangle1(char[][] matrix) {
        int y = matrix.length;
        if(y == 0) return 0;
        int x = matrix[0].length;
        int[][] up = new int[y][x];
        int result = 0;

        for(int i = 0; i < x; i++){
            if(matrix[0][i] == '1'){
                up[0][i] = 1;
            }
            for(int j = 1; j < y; j++){
                if(matrix[j][i] == '1'){
                    if(matrix[j - 1][i] == '0'){
                        up[j][i] = 1;
                    }else{
                        up[j][i] = up[j - 1][i] + 1;
                    }
                }
            }
        }
        for(int i = 0; i < y; i++){
            int now = largestRectangleArea(up[i]);
            if(now > result){
                result = now;
            }
        }
        return result;
    }

    public int largestRectangleArea(int[] heights) {
        int result = 0;
        int length = heights.length;
        if(length == 0) return 0;
        if(length == 1) return heights[0];

        int min = heights[0];
        int num = 0;
        int max = heights[0];
        for(int i = 0; i < heights.length; i++){
            if(heights[i] < min){
                min = heights[i];
                num = i;
            }
            if(heights[i] > min){
                max = heights[i];
            }
        }
        if(max == min) return length * min;

        int r1 = length * min;
        int r2 = 0;
        int r3 = 0;
        if(num == 0){
            r3 = largestRectangleArea(Arrays.copyOfRange(heights, 1, length));
        }else if(num == length - 1){
            r2 = largestRectangleArea(Arrays.copyOfRange(heights, 0, length-1));
        }else{
            r3 = largestRectangleArea(Arrays.copyOfRange(heights, num + 1, length));
            r2 = largestRectangleArea(Arrays.copyOfRange(heights, 0, num));
        }
        return Math.max(r1, Math.max(r2, r3));
    }

    public static void main(String[] args){
        char[][] matrix = {{'0','1','1','0','1'},{'1','1','0','1','0'},{'0','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},{'0','0','0','0','0'}};
        System.out.print(new Solution().maximalRectangle(matrix));
    }
}
