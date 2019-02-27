import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {
    private int[][] longestLocation;
    private int[] globalA;

    // Time O(n * n), too slow
    public int oddEvenJumps(int[] A) {
        int length = A.length;
        globalA = A;
        int result = 0;
        longestLocation = new int[length][2];
        longestLocation[length - 1][0] = length - 1;
        longestLocation[length - 1][1] = length - 1;
        result++;
        for (int i = 0; i < length - 1; i++) {
            longestLocation[i][0] = -1;
            longestLocation[i][1] = -1;
        }
        for (int i = length - 2; i >= 0; i--) {
            int oddLongest = findOddLongest(i);
            int evenLongest = findEvenLongest(i);
            longestLocation[i][0] = oddLongest;
            longestLocation[i][1] = evenLongest;
            if (oddLongest == length - 1) {
                result++;
            }
        }
        return result;
    }

    private int findOddLongest(int i) {
        List<Integer> list = new ArrayList<>();
        for (int j = i + 1; j < globalA.length; j++) {
            if (globalA[j] >= globalA[i]) {
                list.add(j);
            }
        }
        int minLocation = -1;
        int min = Integer.MAX_VALUE;
        for (int k : list) {
            if (globalA[k] < min) {
                min = globalA[k];
                minLocation = k;
            }
        }
        if (minLocation == -1) {
            return -1;
        } else {
            return longestLocation[minLocation][1];
        }
    }

    private int findEvenLongest(int i) {
        List<Integer> list = new ArrayList<>();
        for (int j = i + 1; j < globalA.length; j++) {
            if (globalA[j] <= globalA[i]) {
                list.add(j);
            }
        }
        int maxLocation = -1;
        int max = Integer.MIN_VALUE;
        for (int k : list) {
            if (globalA[k] > max) {
                max = globalA[k];
                maxLocation = k;
            }
        }
        if (maxLocation == -1) {
            return -1;
        } else {
            return longestLocation[maxLocation][0];
        }
    }

    // Time O(nlogn)
    public int oddEvenJumps2(int[] A) {
        int length = A.length;
        int result = 0;
        int[][] longestLocation = new int[length][2];
        longestLocation[length - 1][0] = length - 1;
        longestLocation[length - 1][1] = length - 1;
        result++;
        for (int i = 0; i < length - 1; i++) {
            longestLocation[i][0] = -1;
            longestLocation[i][1] = -1;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[length - 1], length - 1);
        for (int i = length - 2; i >= 0; i--) {
            int oddLongest = -1;
            int evenLongest = -1;
            if (map.containsKey(A[i])) {
                oddLongest = longestLocation[map.get(A[i])][1];
                evenLongest = longestLocation[map.get(A[i])][0];
            } else {
                Integer higherKey = map.higherKey(A[i]);
                Integer lowerKey = map.lowerKey(A[i]);
                if (higherKey != null) {
                    oddLongest = longestLocation[map.get(higherKey)][1];
                }
                if (lowerKey != null) {
                    evenLongest = longestLocation[map.get(lowerKey)][0];
                }
            }
            longestLocation[i][0] = oddLongest;
            longestLocation[i][1] = evenLongest;
            if (oddLongest == length - 1) {
                result++;
            }
            map.put(A[i], i);
        }
        return result;
    }

    // Time O(nlogn)
    public int oddEvenJumps3(int[] A) {
        int length = A.length;
        int result = 0;
        boolean[][] canReach = new boolean[length][2];
        canReach[length - 1][0] = true;
        canReach[length - 1][1] = true;
        result++;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[length - 1], length - 1);
        for (int i = length - 2; i >= 0; i--) {
            boolean odd = false;
            boolean even = false;
            if (map.containsKey(A[i])) {
                odd = canReach[map.get(A[i])][1];
                even = canReach[map.get(A[i])][0];
            } else {
                Integer higherKey = map.higherKey(A[i]);
                Integer lowerKey = map.lowerKey(A[i]);
                if (higherKey != null) {
                    odd = canReach[map.get(higherKey)][1];
                }
                if (lowerKey != null) {
                    even = canReach[map.get(lowerKey)][0];
                }
            }
            canReach[i][0] = odd;
            canReach[i][1] = even;
            if (odd) {
                result++;
            }
            map.put(A[i], i);
        }
        return result;
    }

    // Time O(nlogn), Monotonic stack, Actually slower than TreeMap
    public int oddEvenJumps4(int[] A) {
        int length = A.length;
        int result = 0;
        boolean[][] canReach = new boolean[length][2];
        canReach[length - 1][0] = true;
        canReach[length - 1][1] = true;
        result++;
        Integer[] indexesOne = new Integer[length];
        Integer[] indexesTwo = new Integer[length];
        for (int i = 0; i < length; i++) {
            indexesOne[i] = i;
            indexesTwo[i] = i;
        }
        int[] nextOddPosition = new int[length];
        int[] nextEvenPosition = new int[length];
        Arrays.sort(indexesOne, (k, l) -> (A[k] - A[l]));
        monotonicStack(indexesOne, nextOddPosition);
        Arrays.sort(indexesTwo, (k, l) -> (A[l] - A[k]));
        monotonicStack(indexesTwo, nextEvenPosition);
        for (int i = length - 2; i >= 0; i--) {
            canReach[i][0] = canReach[nextOddPosition[i]][1];
            canReach[i][1] = canReach[nextEvenPosition[i]][0];
            if (canReach[i][0]) {
                result++;
            }
        }
        return result;
    }

    private void monotonicStack(Integer[] indexes, int[] nextPosition) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < indexes.length; i++) {
            while (!stack.isEmpty() && indexes[i] > stack.peek()) {
                nextPosition[stack.pop()] = indexes[i];
            }
            stack.push(indexes[i]);
        }
    }

    public static void main(String[] args) {
        int[] A = {2,3,1,1,4};
        System.out.println(new Solution().oddEvenJumps4(A));
    }
}
