public class Solution {
    // General matrix multiplication
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                int[] vectorA = A[i];
                int product = 0;
                for (int k = 0; k < B.length; k++) {
                    product += vectorA[k] * B[k][j];
                }
                result[i][j] = product;
            }
        }
        return result;
    }

    // Sparse matrix multiplication
    public int[][] multiply2(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < B[0].length; k++) {
                        if (B[j][k] != 0) {
                            result[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 0, 0}, {-1, 0, 3}};
        int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        int[][] result = new Solution().multiply2(A, B);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
