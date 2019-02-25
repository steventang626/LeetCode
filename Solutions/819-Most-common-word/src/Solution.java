import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    class MyComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> one, Map.Entry<String, Integer> two) {
            return two.getValue() - one.getValue();
        }
    }

    // Count and sort, Time O(nlogn)
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += '.';
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(c);
            } else if (word.length() > 0) {
                String wordLow = word.toString().toLowerCase();
                if (!set.contains(wordLow)) {
                    map.put(wordLow, map.getOrDefault(wordLow, 0) + 1);
                }
                word = new StringBuilder();
            }
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, new MyComparator());
        return entryList.get(0).getKey();
    }

    // Count, Time O(n), or more specific O(P + B)
    public String mostCommonWord2(String paragraph, String[] banned) {
        paragraph += '.';
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        StringBuilder word = new StringBuilder();
        int resultNum = 0;
        String result = null;
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(c);
            } else if (word.length() > 0) {
                String wordLow = word.toString().toLowerCase();
                if (!set.contains(wordLow)) {
                    map.put(wordLow, map.getOrDefault(wordLow, 0) + 1);
                    if (map.get(wordLow) > resultNum) {
                        resultNum = map.get(wordLow);
                        result = wordLow;
                    }
                }
                word = new StringBuilder();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a 'ball', the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(new Solution().mostCommonWord2(paragraph, banned));
    }
}
