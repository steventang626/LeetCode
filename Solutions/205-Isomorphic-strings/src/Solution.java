import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic1(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.length() <= 1) return true;
        int[] num1 = new int[256];
        int[] num2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (num1[s.charAt(i)] != num2[t.charAt(i)]) return false;
            num1[s.charAt(i)] = i + 1;
            num2[t.charAt(i)] = i + 1;
        }
        return true;
    }


    // Time O(n)
    // Space O(n)
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.length() <= 1) return true;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)) && !map.containsValue(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            } else if ((!map.containsKey(s.charAt(i))) || (!map.get(s.charAt(i)).equals(t.charAt(i)))){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("eg", "ab"));
    }
}
