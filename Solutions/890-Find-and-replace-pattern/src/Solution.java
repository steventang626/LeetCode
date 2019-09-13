import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (canReplace3(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean canReplace(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        int[] charWord = new int[256];
        int[] charPattern = new int[256];
        for (int i = 0; i < word.length(); i++) {
            if (charWord[word.charAt(i)] != charPattern[pattern.charAt(i)]) {
                return false;
            }
            charWord[word.charAt(i)] = i + 1;
            charPattern[pattern.charAt(i)] = i + 1;
        }
        return true;
    }

    private boolean canReplace2(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        Map<Character, Character> mapWord = new HashMap<>();
        Map<Character, Character> mapPattern = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (!mapWord.containsKey(word.charAt(i))) {
                mapWord.put(word.charAt(i), pattern.charAt(i));
            }
            if (!mapPattern.containsKey(pattern.charAt(i))) {
                mapPattern.put(pattern.charAt(i), word.charAt(i));
            }
            if (mapWord.get(word.charAt(i)) != pattern.charAt(i) || mapPattern.get(pattern.charAt(i)) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean canReplace3(String word, String pattern) {
        Map<Character, Character> mapWord = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (!mapWord.containsKey(word.charAt(i))) {
                mapWord.put(word.charAt(i), pattern.charAt(i));
            }
            if (mapWord.get(word.charAt(i)) != pattern.charAt(i)) {
                return false;
            }
        }
        boolean[] seen = new boolean[256];
        for (char character : mapWord.values()) {
            if (seen[character]) {
                return false;
            }
            seen[character] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        List<String> result = new Solution().findAndReplacePattern(words, "abb");
        for (String word : result) {
            System.out.println(word);
        }
    }
}
