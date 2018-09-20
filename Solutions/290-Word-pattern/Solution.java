import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char temp = pattern.charAt(i);
            if (!map.containsKey(temp) && !map.containsValue(strs[i])) {
                map.put(temp, strs[i]);
            } else if (map.containsKey(temp) && !map.get(temp).equals(strs[i])) {
                return false;
            } else if (map.containsValue(strs[i])) {
                if (!map.containsKey(temp) || !map.get(temp).equals(strs[i])) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba", "dog dog dog dog"));
    }
}
