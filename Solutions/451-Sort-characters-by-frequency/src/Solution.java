import java.io.CharArrayReader;
import java.util.*;

public class Solution {
    // Do not need sort, but it is actually slower.
    // Take attention that if we use String[] stringList, it will exceed the time. So the StringBuilder is faster.
    public String frequencySort1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        StringBuilder[] stringList = new StringBuilder[s.length() + 1];
        for(int i = s.length(); i >= 0; i--) {
            stringList[i] = new StringBuilder();
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            int num = entry.getValue();
            for ( int j = 0; j < num; j++) {
                stringList[num].append(entry.getKey());
            }

        }
        StringBuilder sbResult = new StringBuilder();
        for(int i = s.length(); i >= 1; i--) {
            if (stringList[i] != null) {
                sbResult.append(stringList[i]);
            }
        }
        return sbResult.toString();
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        ValueComparator vc = new ValueComparator();
        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
        list.sort(vc);
        StringBuilder sbResult = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i).getValue();
            for ( int j = 0; j < num; j++)
            sbResult.append(list.get(i).getKey());
        }

        return sbResult.toString();
    }

    private class ValueComparator implements Comparator<Map.Entry<Character, Integer>>
    {
        public int compare(Map.Entry<Character, Integer> mp1, Map.Entry<Character, Integer> mp2) {
            return mp2.getValue() - mp1.getValue();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().frequencySort("tree"));
    }
}
