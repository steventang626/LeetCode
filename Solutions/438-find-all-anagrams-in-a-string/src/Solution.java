import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int s_length = s.length();
        int p_length = p.length();
        int[] p_char = new int[26];
        for (int i = 0; i < p_length; i++) {
            p_char[p.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = 0;
        int count = p_length;
        while (right < s_length) {
            if (p_char[s.charAt(right++) - 'a']-- >= 1) count--;
            if (count == 0) result.add(left);
            if (right - left == p_length && p_char[s.charAt(left++) - 'a']++ >= 0) count++;
        }
        return result;
    }

    // Optimize findAnagrams1
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int s_length = s.length();
        int p_length = p.length();

        int[] p_char = new int[26];
        for (int i = 0; i < p_length; i++) {
            p_char[p.charAt(i) - 'a']++;
        }

        for(int i = 0; i + p_length <= s_length; i++) {
            int[] s_char = new int[26];
            for (int j = i; j < i + p_length; j++) {
                s_char[s.charAt(j) - 'a']++;
            }
            boolean isAnagram = true;
            for (int j = 0; j < 26; j++) {
                if (s_char[j] != p_char[j]) {
                    isAnagram = false;
                    break;
                }
            }
            if (isAnagram) result.add(i);
        }
        return result;
    }

    // Original Solution
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int s_length = s.length();
        int p_length = p.length();

        for(int i = 0; i + p_length <= s_length; i++) {
            if (isAnagram(s.substring(i, i + p_length), p)) {
                result.add(i);
            }
        }
        return result;
    }

    boolean isAnagram (String a, String b) {
        int[] b_char = new int[26];
        for (int i = 0; i < b.length(); i++) {
            b_char[b.charAt(i) - 'a']++;
        }

        for (int i = 0; i < a.length(); i++) {
            b_char[a.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (b_char[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> result = new Solution().findAnagrams("abab", "ab");
        System.out.println(result);
    }
}
