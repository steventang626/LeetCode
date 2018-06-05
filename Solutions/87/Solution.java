import java.util.Arrays;

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);
        String s1_new = new String(arr1);
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr2);
        String s2_new = new String(arr2);
        if(!s1_new.equals(s2_new)) return false;
        else if(s1.length() <= 3) return true;
        for(int i = 1; i < s1.length(); i++){
            String s11 = s1.substring(0,i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0,i);
            String s22 = s2.substring(i);
            if(isScramble(s11, s21) && isScramble(s12, s22)) return true;
            s21 = s2.substring(s1.length() - i);
            s22 = s2.substring(0, s1.length() - i);
            if(isScramble(s11, s21) && isScramble(s12, s22)) return true;
         }
        return false;
    }
    public static void main(String[] args){
        System.out.println(new Solution().isScramble("abcd","bdac"));
    }
}
