public class Solution {
    // Time O(n ^ 2), Space O(1)
    public int totalFruit(int[] tree) {
        int result = 0;
        for (int i = 0; i < tree.length; i++) {
            int recent = calculateFruit(tree, i);
            if (recent > result) {
                result = recent;
            }
        }
        return result;
    }

    private int calculateFruit(int[] tree, int position) {
        int[][] fruits = new int[2][2];
        fruits[0][0] = -1;
        fruits[1][0] = -1;
        for(int i = position; i < tree.length; i++) {
            if (fruits[0][0] == -1) {
                fruits[0][0] = tree[i];
                fruits[0][1]++;
            } else if (fruits[0][0] == tree[i]) {
                fruits[0][1]++;
            } else if (fruits[1][0] == -1) {
                fruits[1][0] = tree[i];
                fruits[1][1]++;
            } else if (fruits[1][0] == tree[i]) {
                fruits[1][1]++;
            } else {
                break;
            }
        }
        return fruits[0][1] + fruits[1][1];
    }

    // Time O(n), Space O(1)
    public int totalFruit2(int[] tree) {
        int result = 0;
        int[][] fruits = new int[2][2];
        fruits[0][0] = -1;
        fruits[1][0] = -1;
        int i = 0, j = 0;
        while (i < tree.length) {
            while (j < tree.length) {
                if (fruits[0][0] == -1) {
                    fruits[0][0] = tree[j];
                    fruits[0][1]++;
                } else if (fruits[0][0] == tree[j]) {
                    fruits[0][1]++;
                } else if (fruits[1][0] == -1) {
                    fruits[1][0] = tree[j];
                    fruits[1][1]++;
                } else if (fruits[1][0] == tree[j]) {
                    fruits[1][1]++;
                } else {
                    break;
                }
                j++;
            }
            int recent = fruits[0][1] + fruits[1][1];
            if (recent > result) {
                result = recent;
            }
            if (j >= tree.length || i + result > tree.length) {
                break;
            } else {
                if (fruits[0][0] == tree[i]) {
                    fruits[0][1]--;
                    if (fruits[0][1] == 0) {
                        fruits[0][0] = -1;
                    }
                } else if (fruits[1][0] == tree[i]) {
                    fruits[1][1]--;
                    if (fruits[1][1] == 0) {
                        fruits[1][0] = -1;
                    }
                }
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] tree = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(new Solution().totalFruit2(tree));
    }
}
