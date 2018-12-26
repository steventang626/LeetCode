public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(String word: words) {
            stringBuilder.append(reverseString(word));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }
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
        return String.valueOf(sChar);
    }

    public String reverseWords2(String s) {
        String[] words = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(String word: words) {
            stringBuilder.append(new StringBuilder(word).reverse().toString());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(new Solution().reverseWords2(s));
    }
}
