public class Solution {
    public static String longestPalindrome(String s) {
        int startIdx = 0, left = 0, right = 0, length = 0;
        int[] result = new int[2];
        for (int i = 0;i<s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                left = i;
                right = i+1;
                result = searchPalindroms(s, left, right, startIdx, length);
                startIdx = result[0];
                length = result[1];
            }
            left = i;
            right = i;
            result = searchPalindroms(s, left, right, startIdx, length);
            startIdx = result[0];
            length = result[1];
        }
        if (length == 0) length = s.length(); // length = 1
        return s.substring(startIdx,startIdx + length);
    }
    public static int[] searchPalindroms(String s, int left, int right, int startIdx, int length){
        int[] result = new int[2];
        int step = 1;
        while((left - step) >= 0 && (right + step) < s.length()){
            if(s.charAt(left - step) != s.charAt(right + step)) break;
            step++;
        }
        int wide  = right - left + 2*step -1;
        if(length < wide){
            length = wide;
            startIdx = left - step +1;
        }
        result[0] = startIdx;
        result[1] = length;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }
}
