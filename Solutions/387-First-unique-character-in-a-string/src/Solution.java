import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int firstUniqueChar(String s) {
        int[] characters = new int[26];
        for(int i = 0; i < s.length(); i++) {
            characters[s.charAt(i) - 'a']++;
        }
        int result = -1;
        for(int i = 0; i < s.length(); i++) {
            if(characters[s.charAt(i) - 'a'] == 1) {
                result = i;
                break;
            }
        }
        return result;
    }

    public int firstUniqueChar2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char recent = s.charAt(i);
            map.put(recent, map.getOrDefault(recent, 0) + 1);
        }
        int result = -1;
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqueChar2("loveleetcode"));
    }
}
