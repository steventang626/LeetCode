import java.util.Arrays;

public class Solution {
    // Time O(n)
    // Space O(1)
    public String reverseVowels(String s) {
        if (s.length() <= 1) return s;
        char[] sChar = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!((sChar[left] == 'a') || (sChar[left] == 'e') || (sChar[left] == 'i') || (sChar[left] == 'o') || (sChar[left] == 'u')
            || (sChar[left] == 'A') || (sChar[left] == 'E') || (sChar[left] == 'I') || (sChar[left] == 'O') || (sChar[left] == 'U'))) {
                left++;
                continue;
            }
            if (!((sChar[right] == 'a') || (sChar[right] == 'e') || (sChar[right] == 'i') || (sChar[right] == 'o') || (sChar[right] == 'u')
                    || (sChar[right] == 'A') || (sChar[right] == 'E') || (sChar[right] == 'I') || (sChar[right] == 'O') || (sChar[right] == 'U'))) {
                right--;
                continue;
            }
            char temp = sChar[left];
            sChar[left] = sChar[right];
            sChar[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(sChar);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new Solution().reverseVowels(s));
    }
}
