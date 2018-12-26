import java.util.HashSet;
import java.util.Set;

public class Solution {
    // Time O(J.length+S.length), Space: O(1)
    public int numJewelsInStones(String J, String S) {
        int result = 0, lengthOfS = S.length(), lengthOfJ = J.length();
        int[] numOfCharacters = new int[52];
        for(int i = 0; i < lengthOfS; i++) {
            char recent = S.charAt(i);
            if(recent >= 'a') {
                numOfCharacters[26 + recent - 'a']++;
            } else {
                numOfCharacters[recent - 'A']++;
            }
        }
        for(int i = 0; i < lengthOfJ; i++) {
            char recent = J.charAt(i);
            if(recent >= 'a') {
                result += numOfCharacters[26 + recent - 'a'];
            } else {
                result += numOfCharacters[recent - 'A'];
            }
        }
        return result;
    }

    // Time O(J.length+S.length), Space: O(J.length)
    public int numJewelsInStones2(String J, String S) {
        int result = 0;
        char[] charOfJ = J.toCharArray();
        char[] charOfS = S.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char j: charOfJ) {
            set.add(j);
        }
        for(char s: charOfS) {
            if(set.contains(s)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int result = new Solution().numJewelsInStones2("aA", "adAAmm");
        System.out.println(result);
    }
}
