public class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[] nums = new int[6];
        int length = A.length;
        for (int i = 0; i < length; i++) {
            nums[A[i] - 1]++;
            nums[B[i] - 1]++;
        }
        int max = 0;
        int maxNum = 0;
        for (int i = 0; i < 6; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                max = i + 1;
            }
        }
        if (maxNum < length) {
            return -1;
        }
        int numChangeIntoA = 0;
        int numChangeIntoB = 0;
        for (int i = 0; i < length; i++) {
            if (A[i] != max && B[i] != max) {
                return -1;
            }
            if (A[i] != max) {
                numChangeIntoA++;
            } else if (B[i] != max) {
                numChangeIntoB++;
            }
        }
        return Math.min(numChangeIntoA, numChangeIntoB);
    }

    private int checkCanRotate(int x, int[] A, int[] B) {
        int length = A.length;
        int numChangeIntoA = 0;
        int numChangeIntoB = 0;
        for (int i = 0; i < length; i++) {
            if (A[i] != x && B[i] != x) {
                return -1;
            }
            if (A[i] != x) {
                numChangeIntoA++;
            } else if (B[i] != x) {
                numChangeIntoB++;
            }
        }
        return Math.min(numChangeIntoA, numChangeIntoB);
    }

    public int minDominoRotations2(int[] A, int[] B) {
        int checkCanRotateToA0 = checkCanRotate(A[0], A, B);
        if (checkCanRotateToA0 != -1 || A[0] == B[0]) {
            return checkCanRotateToA0;
        }
        return checkCanRotate(B[0], A, B);
    }

    public static void main(String[] args) {
	    int[] A = {2, 1, 2, 4, 2, 2};
        int[] B = {5, 2, 6, 2, 3, 2};
        System.out.println(new Solution().minDominoRotations2(A, B));
    }
}
