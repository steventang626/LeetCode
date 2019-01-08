import javafx.util.Pair;

import java.util.*;

public class Solution {
    // Too slow, cannot pass OJ
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = wordList.size();
        Map<String, List<String>> relatedWords = new HashMap<>();
        int lengthOfBeginWord = beginWord.length();
        List<String> relatedWordsOfBeginWord = new ArrayList<>();
        for(int i = 0; i < lengthOfBeginWord; i++) {
            for(int j = 0; j < 26; j++) {
                String recent = beginWord.substring(0, i) + (char)('a' + j) + beginWord.substring(i + 1, lengthOfBeginWord);
                if(!recent.equals(beginWord) && wordList.contains(recent)) {
                    relatedWordsOfBeginWord.add(recent);
                }
            }
        }
        relatedWords.put(beginWord, relatedWordsOfBeginWord);

        for(int k = 0; k < length; k++) {
            String word = wordList.get(k);
            List<String> relatedWordsOfOneWord = new ArrayList<>();
            int lengthOfWord = word.length();
            for(int i = 0; i < lengthOfWord; i++) {
                for(int j = 0; j < 26; j++) {
                    String recent = word.substring(0, i) + (char)('a' + j) + word.substring(i + 1, lengthOfWord);
                    if(!recent.equals(word) && wordList.contains(recent)) {
                        relatedWordsOfOneWord.add(recent);
                    }
                }
            }
            relatedWords.put(word, relatedWordsOfOneWord);
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        int result = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String recent = pair.getKey();
            int step = pair.getValue();
            List<String> neighbors = relatedWords.get(recent);
            for(int i = 0; i < neighbors.size(); i++) {
                String neighbor = neighbors.get(i);
                if(!set.contains(neighbor)) {
                    if(neighbor.equals(endWord)) {
                        if(step + 1 < result) result = step + 1;
                    }
                    queue.add(new Pair<>(neighbor, step + 1));
                    set.add(neighbor);
                }
            }
        }
        if(result == Integer.MAX_VALUE)
            return 0;
        else
            return result;
    }

    public boolean isRelated(String strOne, String strTwo) {
        int lengthOne = strOne.length();
//        int lengthTwo = strTwo.length();
//        if(lengthOne != lengthTwo) return false;
        int num = 0;
        for(int i = 0; i < lengthOne; i++) {
            char one = strOne.charAt(i);
            char two = strTwo.charAt(i);
            if(one != two) num++;
            if(num > 1) return false;
        }
        return num == 1;
    }

    // 能通过OJ
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int length = wordList.size();
        Map<String, List<String>> relatedWords = new HashMap<>();
        List<String> relatedWordsOfBeginWord = new ArrayList<>();
        for(String str : wordList) {
            if(isRelated(beginWord, str)) relatedWordsOfBeginWord.add(str);
        }
        relatedWords.put(beginWord, relatedWordsOfBeginWord);

        for(int k = 0; k < length; k++) {
            String word = wordList.get(k);
            List<String> relatedWordsOfOneWord = new ArrayList<>();
            for(String str : wordList) {
                if(isRelated(word, str)) relatedWordsOfOneWord.add(str);
            }
            relatedWords.put(word, relatedWordsOfOneWord);
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        int result = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String recent = pair.getKey();
            int step = pair.getValue();
            List<String> neighbors = relatedWords.get(recent);
            for(int i = 0; i < neighbors.size(); i++) {
                String neighbor = neighbors.get(i);
                if(!set.contains(neighbor)) {
                    if(neighbor.equals(endWord)) {
                        if(step + 1 < result) result = step + 1;
                        return result;
                    }
                    queue.add(new Pair<>(neighbor, step + 1));
                    set.add(neighbor);
                }
            }
        }
        return 0;
    }

    // 反而慢
    public boolean isRelated2(char[] strOne, char[] strTwo) {
        int lengthOne = strOne.length;
        int num = 0;
        for(int i = 0; i < lengthOne; i++) {
            char one = strOne[i];
            char two = strTwo[i];
            if(one != two) num++;
            if(num > 1) return false;
        }
        return num == 1;
    }

    // 慢
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        int length = wordList.size();
        Map<String, List<String>> relatedWords = new HashMap<>();
        List<String> relatedWordsOfBeginWord = new ArrayList<>();
        char[] beginChars = beginWord.toCharArray();
        for(String str : wordList) {
            char[] chars = str.toCharArray();
            if(isRelated2(beginChars, chars)) relatedWordsOfBeginWord.add(str);
        }
        relatedWords.put(beginWord, relatedWordsOfBeginWord);

        for(int k = 0; k < length; k++) {
            String word = wordList.get(k);
            char[] wordChars = word.toCharArray();
            List<String> relatedWordsOfOneWord = new ArrayList<>();
            for(String str : wordList) {
                char[] chars = str.toCharArray();
                if(isRelated2(wordChars, chars)) relatedWordsOfOneWord.add(str);
            }
            relatedWords.put(word, relatedWordsOfOneWord);
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        int result = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String recent = pair.getKey();
            int step = pair.getValue();
            List<String> neighbors = relatedWords.get(recent);
            for(int i = 0; i < neighbors.size(); i++) {
                String neighbor = neighbors.get(i);
                if(!set.contains(neighbor)) {
                    if(neighbor.equals(endWord)) {
                        if(step + 1 < result) result = step + 1;
                    }
                    queue.add(new Pair<>(neighbor, step + 1));
                    set.add(neighbor);
                }
            }
        }
        if(result == Integer.MAX_VALUE)
            return 0;
        else
            return result;
    }

    public int ladderLength4(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        Set<String> visited = new HashSet<>();
        Set<String> dictionary = new HashSet<>(wordList);
        visited.add(beginWord);
        while(!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String recent = pair.getKey();
            int step = pair.getValue();
            int length = recent.length();
            char[] chars = recent.toCharArray();
            for(int k = 0; k < length; k++) {
                char c = chars[k];
                for(char i = 'a'; i <= 'z'; i++) {
                    chars[k] = i;
                    String newWord = String.valueOf(chars);
                    if(dictionary.contains(newWord) && newWord.equals(endWord)) return step + 1;
                    if(dictionary.contains(newWord) && !visited.contains(newWord)) {
                        queue.add(new Pair<>(newWord, step + 1));
                        visited.add(newWord);
                    }
                }
                chars[k] = c;
            }
        }
        return 0;
    }

    public int ladderLength5(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> dictionary = new HashSet<>(wordList);
        int result = 1;
        while(!queue.isEmpty()) {
            for(int j = queue.size(); j > 0; j--) {
                String recent = queue.poll();
                if(recent.equals(endWord)) return result;
                int length = recent.length();
                char[] chars = recent.toCharArray();
                for(int k = 0; k < length; k++) {
                    char c = chars[k];
                    for(char i = 'a'; i <= 'z'; i++) {
                        chars[k] = i;
                        String newWord = String.valueOf(chars);
                        if(dictionary.contains(newWord) && !newWord.equals(recent)) {
                            queue.add(newWord);
                            dictionary.remove(newWord);
                        }
                    }
                    chars[k] = c;
                }
            }
            result++;
        }
        return 0;
    }

    // 相比5要慢一些
    public int ladderLength6(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> dictionary = new HashSet<>(wordList);
        int result = 1;
        while(!queue.isEmpty()) {
            for(int j = queue.size(); j > 0; j--) {
                String recent = queue.poll();
                if(recent.equals(endWord)) return result;
                int length = recent.length();
                StringBuilder sb = new StringBuilder(recent);
                for(int k = 0; k < length; k++) {
                    char c = recent.charAt(k);
                    for(char i = 'a'; i <= 'z'; i++) {
                        sb.setCharAt(k, i);
                        String newWord = sb.toString();
                        if(dictionary.contains(newWord) && !newWord.equals(recent)) {
                            queue.add(newWord);
                            dictionary.remove(newWord);
                        }
                    }
                    sb.setCharAt(k, c);
                }
            }
            result++;
        }
        return 0;
    }

    // 相比5要慢一些
    public int ladderLength7(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> dictionary = new HashSet<>(wordList);
        int result = 1;
        while(!queue.isEmpty()) {
            for(int j = queue.size(); j > 0; j--) {
                String recent = queue.poll();
                if(recent.equals(endWord)) return result;
                int length = recent.length();
                for(String str : wordList) {
                    if(isRelated(recent, str) && dictionary.contains(str) && !str.equals(recent)) {
                        queue.add(str);
                        dictionary.remove(str);
                    }
                }
            }
            result++;
        }
        return 0;
    }

    // 针对最原始版本的改进
    public int ladderLength8(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        int length = wordList.size();
        Map<String, List<String>> relatedWords = new HashMap<>();
        int lengthOfBeginWord = beginWord.length();
        List<String> relatedWordsOfBeginWord = new ArrayList<>();
        for(int i = 0; i < lengthOfBeginWord; i++) {
            for(int j = 0; j < 26; j++) {
                String recent = beginWord.substring(0, i) + (char)('a' + j) + beginWord.substring(i + 1, lengthOfBeginWord);
                if(!recent.equals(beginWord) && dictionary.contains(recent)) {
                    relatedWordsOfBeginWord.add(recent);
                }
            }
        }
        relatedWords.put(beginWord, relatedWordsOfBeginWord);

        for(int k = 0; k < length; k++) {
            String word = wordList.get(k);
            List<String> relatedWordsOfOneWord = new ArrayList<>();
            int lengthOfWord = word.length();
            for(int i = 0; i < lengthOfWord; i++) {
                for(int j = 0; j < 26; j++) {
                    String recent = word.substring(0, i) + (char)('a' + j) + word.substring(i + 1, lengthOfWord);
                    if(!recent.equals(word) && dictionary.contains(recent)) {
                        relatedWordsOfOneWord.add(recent);
                    }
                }
            }
            relatedWords.put(word, relatedWordsOfOneWord);
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        while(!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String recent = pair.getKey();
            int step = pair.getValue();
            List<String> neighbors = relatedWords.get(recent);
            for(int i = 0; i < neighbors.size(); i++) {
                String neighbor = neighbors.get(i);
                if(!set.contains(neighbor)) {
                    if(neighbor.equals(endWord)) {
                         return step + 1;
                    }
                    queue.add(new Pair<>(neighbor, step + 1));
                    set.add(neighbor);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(new Solution().ladderLength5(beginWord, endWord, wordList));
    }
}
