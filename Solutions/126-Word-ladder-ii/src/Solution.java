import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

class Solution {
    // Can pass the OJ, but a little bit slow
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> resultList = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> dictionary = new HashSet<>(wordList);
        dictionary.remove(beginWord);
        int step = 1;
        int minStep = Integer.MAX_VALUE;
        List<String> resultChain = new ArrayList<>();
        resultChain.add(beginWord);
        queue.add(resultChain);
        while(!queue.isEmpty()) {
            for(int j = queue.size(); j > 0; j--) {
                List<String> recentList = queue.poll();
                String recent = recentList.get(recentList.size() - 1);
                if(recent.equals(endWord)) {
                    if(step <= minStep) {
                        minStep = step;
                        resultList.add(recentList);
                    } else {
                        break;
                    }
                }
                dictionary.remove(recent);

                int length = recent.length();
                char[] chars = recent.toCharArray();
                for(int k = 0; k < length; k++) {
                    char c = chars[k];
                    for(char i = 'a'; i <= 'z'; i++) {
                        chars[k] = i;
                        String newWord = String.valueOf(chars);
                        if(dictionary.contains(newWord) && !newWord.equals(recent)) {
                            List<String> recentList2 = new ArrayList<>(recentList);
                            recentList2.add(newWord);
                            queue.add(recentList2);
                        }
                    }
                    chars[k] = c;
                }
            }
            step++;
            if(step > minStep) break;
        }
        return resultList;
    }

    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> resultList = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> dictionary = new HashSet<>(wordList);
        Set<String> words = new HashSet<>();
        dictionary.remove(beginWord);
        int step = 1;
        int minStep = Integer.MAX_VALUE;
        List<String> resultChain = new ArrayList<>();
        resultChain.add(beginWord);
        queue.add(resultChain);
        while(!queue.isEmpty()) {
            List<String> recentList = queue.poll();
            if(recentList.size() > step) {
                for(String word : words) dictionary.remove(word);
                words.clear();
                step = recentList.size();
                if(step > minStep) break;
            }
            String recent = recentList.get(recentList.size() - 1);
            int length = recent.length();
            char[] chars = recent.toCharArray();
            for(int k = 0; k < length; k++) {
                char c = chars[k];
                for(char i = 'a'; i <= 'z'; i++) {
                    chars[k] = i;
                    String newWord = String.valueOf(chars);
                    if(!dictionary.contains(newWord)) continue;
                    words.add(newWord);
                    List<String> nextPath = new ArrayList<>(recentList);
                    nextPath.add(newWord);
                    if(newWord.equals(endWord)) {
                        resultList.add(nextPath);
                        minStep = step;
                    } else {
                        queue.add(nextPath);
                    }
                }
                chars[k] = c;
            }
        }
        return resultList;
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
        List<List<String>> result = new Solution().findLadders(beginWord, endWord, wordList);
        for(List<String> list : result) {
            for(String str: list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }

    }
}