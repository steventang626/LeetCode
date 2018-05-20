public class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] result = new int[length1 + 1][length2 + 1];
        for(int i = 0; i <= length1; i++){
            result[i][0] = i;
        }
        for(int i = 0; i <= length2; i++){
            result[0][i] = i;
        }
        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    result[i][j] = result[i - 1][j - 1];
                }else{
                    result[i][j] = Math.min(Math.min(result[i - 1][j - 1], result[i - 1][j]), result[i][j - 1]) + 1;
                }
            }
        }
        return result[length1][length2];
    }
    public static void main(String[] args){
        System.out.print(new Solution().minDistance("intention","execution"));
    }
}
