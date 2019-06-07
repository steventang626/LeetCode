import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * Time O(NlogN)
     */
    public int[] sortedSquares(int[] A) {
        List<Integer> sortedSquaresList = new ArrayList<>();
        for (int i : A) {
            sortedSquaresList.add(i * i);
        }
        Collections.sort(sortedSquaresList);
        int[] result = new int[A.length];
        for (int i = 0; i < sortedSquaresList.size(); i++) {
            result[i] = sortedSquaresList.get(i);
        }
        return result;
    }

    public int[] sortedSquares2(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    /**
     * Time O(N)
     */
    public int[] sortedSquares3(int[] A) {
        int[] result = new int[A.length];
        if (A.length == 0) {
            return result;
        }
        if (A[0] >= 0) {
            for (int i = 0; i < A.length; i++) {
                result[i] = A[i] * A[i];
            }
        } else if (A[A.length - 1] <= 0) {
            for (int i = 0; i < A.length; i++) {
                result[A.length - i - 1] = A[i] * A[i];
            }
        } else {
            int indexRight = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] >= 0) {
                    indexRight = i;
                    break;
                }
            }
            int indexLeft = indexRight - 1;
            List<Integer> abstractNumbersList = new ArrayList<>();
            while (indexLeft >= 0 && indexRight <= A.length - 1) {
                if (-A[indexLeft] <= A[indexRight]) {
                    abstractNumbersList.add(A[indexLeft]);
                    indexLeft--;
                } else {
                    abstractNumbersList.add(A[indexRight]);
                    indexRight++;
                }
            }
            while (indexLeft >= 0) {
                abstractNumbersList.add(A[indexLeft]);
                indexLeft--;
            }
            while (indexRight <= A.length - 1) {
                abstractNumbersList.add(A[indexRight]);
                indexRight++;
            }
            for (int i = 0; i < abstractNumbersList.size(); i++) {
                result[i] = abstractNumbersList.get(i) * abstractNumbersList.get(i);
            }
        }
        return result;
    }

    public int[] sortedSquares4(int[] A) {
        int[] result = new int[A.length];
        int indexRight = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                indexRight = i;
                break;
            }
        }
        int indexLeft = indexRight - 1;
        List<Integer> abstractNumbersList = new ArrayList<>();
        while (indexLeft >= 0 && indexRight <= A.length - 1) {
            if (-A[indexLeft] <= A[indexRight]) {
                abstractNumbersList.add(A[indexLeft]);
                indexLeft--;
            } else {
                abstractNumbersList.add(A[indexRight]);
                indexRight++;
            }
        }
        while (indexLeft >= 0) {
            abstractNumbersList.add(A[indexLeft]);
            indexLeft--;
        }
        while (indexRight <= A.length - 1) {
            abstractNumbersList.add(A[indexRight]);
            indexRight++;
        }
        for (int i = 0; i < abstractNumbersList.size(); i++) {
            result[i] = abstractNumbersList.get(i) * abstractNumbersList.get(i);
        }
        return result;
    }

    public int[] sortedSquares5(int[] A) {
        int[] result = new int[A.length];
        int indexRight = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                indexRight = i;
                break;
            }
        }
        int indexLeft = indexRight - 1;
        int resultIndex = 0;
        while (indexLeft >= 0 && indexRight <= A.length - 1) {
            if (-A[indexLeft] <= A[indexRight]) {
                result[resultIndex++] = A[indexLeft] * A[indexLeft];
                indexLeft--;
            } else {
                result[resultIndex++] = A[indexRight] * A[indexRight];
                indexRight++;
            }
        }
        while (indexLeft >= 0) {
            result[resultIndex++] = A[indexLeft] * A[indexLeft];
            indexLeft--;
        }
        while (indexRight <= A.length - 1) {
            result[resultIndex++] = A[indexRight] * A[indexRight];
            indexRight++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {-3, -2, 5, 6};
        int[] result = new Solution().sortedSquares5(A);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
