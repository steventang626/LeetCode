import java.util.Arrays;

public class Solution {
    // Time O(n)
    // Space O(n)
    public String reverseString1(String s) {
        if (s.length() <= 1) return s;
        StringBuilder strResult = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            strResult.append(s.charAt(i));
        }
        return strResult.toString();
    }

    // Time O(n)
    // Space O(1)
    // 时间上也比reverseString1快
    public String reverseString(String s) {
        if (s.length() <= 1) return s;
        char[] sChar = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char temp = sChar[left];
            sChar[left] = sChar[right];
            sChar[right] = temp;
            left++;
            right--;
        }
        // 注意下面的这个方法，而不是 sChar.toString()
        return String.valueOf(sChar);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new Solution().reverseString(s));
    }
}
