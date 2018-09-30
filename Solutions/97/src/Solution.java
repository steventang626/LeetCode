public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        if(s1.isEmpty()) return s2.equals(s3);
        if(s2.isEmpty()) return s1.equals(s3);
        boolean results[][] = new boolean[s1.length() + 1][s2.length() + 1];
        results[0][0] = true;
        for(int i = 0; i < results[0].length - 1; i++){
            if(s2.charAt(i) == s3.charAt(i) && results[0][i]) results[0][i + 1] = true;
        }
        for(int i = 0; i < results.length - 1; i++){
            if(s1.charAt(i) == s3.charAt(i) && results[i][0]) results[i + 1][0] = true;
        }
        for(int i = 1; i < results.length; i++){
            for(int j = 1; j < results[0].length; j++){
                results[i][j] = (results[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(j + i - 1))) || (results[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(j + i - 1)));
            }
        }

//        for(int i = 0; i < results.length; i++){
//            for(int j = 0; j < results[0].length; j++){
//                System.out.print(results[i][j] + " ");
//            }
//            System.out.println();
//        }

        return results[s1.length()][s2.length()];
    }

    public boolean isInterleave1(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        if(s1.isEmpty()) return s2.equals(s3);
        if(s2.isEmpty()) return s1.equals(s3);
        char s1_first = s1.charAt(0);
        char s2_first = s2.charAt(0);
        if(s1_first != s2_first){
            if(s3.charAt(0) == s1_first){
                return isInterleave(s1.substring(1,s1.length()), s2, s3.substring(1, s3.length()));
            }else if(s3.charAt(0) == s2_first) {
                return isInterleave(s1, s2.substring(1, s2.length()), s3.substring(1, s3.length()));
            } else return false;
        } else return (s3.charAt(0) == s1_first && (isInterleave(s1.substring(1, s1.length()), s2, s3.substring(1, s3.length())) || isInterleave(s1, s2.substring(1, s2.length()), s3.substring(1, s3.length()))));
    }
    public static void main(String[] args){
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
