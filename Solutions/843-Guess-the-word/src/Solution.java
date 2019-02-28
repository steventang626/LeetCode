import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

interface Master {
    public int guess(String word);
}

class GuessMaster implements Master {
    private Set<String> set;
    private String guessWord;
    GuessMaster(String[] wordlist, String guessWord) {
        set = new HashSet<>();
        Collections.addAll(set, wordlist);
        this.guessWord = guessWord;
    }

    @Override
    public int guess(String word) {
        if (set.contains(word)) {
            if (word.equals(guessWord)) {
                return 6;
            } else {
                int result = 0;
                for (int i = 0; i < 6; i++) {
                    if (guessWord.charAt(i) == word.charAt(i)) {
                        result++;
                    }
                }
                return result;
            }
        } else {
            return -1;
        }
    }
}

public class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        int[][] guessResults = new int[wordlist.length][wordlist.length];
        for (int i = 0; i < wordlist.length; i++) {
            String word = wordlist[i];
            for (int k = i; k < wordlist.length; k++) {
                int result = 0;
                String recentWord = wordlist[k];
                for (int j = 0; j < 6; j++) {
                    if (word.charAt(j) == recentWord.charAt(j)) {
                        result++;
                    }
                }
                guessResults[i][k] = result;
                guessResults[k][i] = result;
            }
        }
        Map<String, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < wordlist.length; i++) {
            resultMap.put(wordlist[i], i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(resultMap.size());
            if (resultMap.size() == 1) {
                master.guess(resultMap.keySet().iterator().next());
                return;
            } else {
                String next = resultMap.keySet().iterator().next();
                int number = master.guess(next);
                int index = resultMap.get(next);
                for (int k = 0; k < wordlist.length; k++) {
                    if (guessResults[index][k] != number) {
                        resultMap.remove(wordlist[k]);
                    }
                }
            }
        }
    }

    public void findSecretWord2(String[] wordlist, Master master) {
        Set<String> resultSet = new HashSet<>();
        Collections.addAll(resultSet, wordlist);

        for (int i = 0; i < 10; i++) {
            System.out.println(resultSet.size());
            if (resultSet.size() == 1) {
                master.guess(resultSet.iterator().next());
                return;
            } else {
                String next = resultSet.iterator().next();
                int number = master.guess(next);
                for (int k = 0; k < wordlist.length; k++) {
                    int result = 0;
                    String recentWord = wordlist[k];
                    for (int j = 0; j < 6; j++) {
                        if (next.charAt(j) == recentWord.charAt(j)) {
                            result++;
                        }
                    }
                    if (result != number) {
                        resultSet.remove(recentWord);
                    }
                }
            }
        }
    }

    public void findSecretWord3(String[] wordlist, Master master) {
        Set<String> resultSet = new HashSet<>();
        Collections.addAll(resultSet, wordlist);

        for (int i = 0; i < 10; i++) {
            System.out.println(resultSet.size());
            if (resultSet.size() == 1) {
                master.guess(resultSet.iterator().next());
                return;
            } else {
                String next = resultSet.iterator().next();
                int number = master.guess(next);
                // System.out.println(next + number);
                Set<String> recentSet = new HashSet<>(resultSet);
                for (String recentWord : recentSet) {
                    int result = 0;
                    for (int j = 0; j < 6; j++) {
                        if (next.charAt(j) == recentWord.charAt(j)) {
                            result++;
                        }
                    }
                    if (result != number) {
                        resultSet.remove(recentWord);
                    }
                }
            }
        }
    }

    public void findSecretWord4(String[] wordlist, Master master) {
        List<String> resultList = new ArrayList<>();
        Collections.addAll(resultList, wordlist);
        for (int i = 0; i < 10; i++) {
            System.out.println(resultList.size());
            if (resultList.size() == 1) {
                master.guess(resultList.get(0));
                return;
            } else {
                int randomIndex = new Random().nextInt(resultList.size());
                String next = resultList.get(randomIndex);
                int number = master.guess(next);
                // System.out.println(next + number);
                List<String> recentList = new ArrayList<>();
                for (String recentWord : resultList) {
                    int result = 0;
                    for (int j = 0; j < 6; j++) {
                        if (next.charAt(j) == recentWord.charAt(j)) {
                            result++;
                        }
                    }
                    if (result == number) {
                        recentList.add(recentWord);
                    }
                }
                resultList = recentList;
            }
        }
    }

    // MiniMax
    public void findSecretWord5(String[] wordlist, Master master) {
        int[][] guessResults = new int[wordlist.length][wordlist.length];
        for (int i = 0; i < wordlist.length; i++) {
            String word = wordlist[i];
            for (int k = i; k < wordlist.length; k++) {
                int result = 0;
                String recentWord = wordlist[k];
                for (int j = 0; j < 6; j++) {
                    if (word.charAt(j) == recentWord.charAt(j)) {
                        result++;
                    }
                }
                guessResults[i][k] = result;
                guessResults[k][i] = result;
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < wordlist.length; i++) {
            resultList.add(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(resultList.size());
            if (resultList.size() == 1) {
                master.guess(wordlist[resultList.get(0)]);
                return;
            } else {
                int guessIndex = findMiniMax(guessResults, resultList);
                String next = wordlist[guessIndex];
                int number = master.guess(next);
                // System.out.println(next + number);
                List<Integer> recentList = new ArrayList<>();
                for (Integer possible : resultList) {
                    if (guessResults[possible][guessIndex] == number) {
                        recentList.add(possible);
                    }
                }
                resultList = recentList;
            }
        }
    }

    private int findMiniMax(int[][] guessResults, List<Integer> resultList) {
        int result = -1;
        List<Integer> resultListCopy = resultList;
        for (int guess = 0; guess < guessResults.length; guess++) {
            ArrayList<Integer>[] groups = new ArrayList[7];
            for (int i = 0; i < 7; i++) {
                groups[i] = new ArrayList<>();
            }
            for (Integer j : resultList) {
                groups[guessResults[j][guess]].add(j);
            }
            ArrayList<Integer> maxGroup = groups[0];
            for (int i = 1; i < 7; i++) {
                if (groups[i].size() > maxGroup.size()) {
                    maxGroup = groups[i];
                }
            }
            if (maxGroup.size() < resultListCopy.size()) {
                resultListCopy = maxGroup;
                result = guess;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] wordlist = {"aaaaaa","bbbbbb","cccccc","dddddd","eeeeee","ffffff","gggggg","hhhhhh","iiiiii","jjjjjj","kkkkkk", "llllll", "aaabbb"};
        GuessMaster guessMaster = new GuessMaster(wordlist, "kkkkkk");
        new Solution().findSecretWord5(wordlist, guessMaster);
    }
}
