public class Solution {
    public int numTrees(int n) {
        int[] numTree = new int[n + 1];
        numTree[0] = 1;
        numTree[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                numTree[i] += numTree[j] * numTree[i - j - 1];
            }
        }
        return numTree[n];
    }

    public static void main(String[] args){
        int result = new Solution().numTrees(3);
        System.out.println(result);
    }
}
