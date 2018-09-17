public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] sMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sMap[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            sMap[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (sMap[i] != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        boolean result = new Solution().isAnagram("abbc","cabb");
        System.out.print(result);
    }
}
