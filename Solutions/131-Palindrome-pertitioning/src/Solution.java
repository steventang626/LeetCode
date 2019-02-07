import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<String>> resultList;

    public List<List<String>> partition(String s) {
        resultList = new ArrayList<>();
        if (s.length() > 0) {
            partitionHelper(s, new ArrayList<>());
        }
        return resultList;
    }

    public void partitionHelper(String string, List<String> recentResult) {
        if (string.length() == 0) {
            resultList.add(new ArrayList<>(recentResult));
            return;
        }
        for(int i = 1; i <= string.length(); i++) {
            String stringToBeChecked = string.substring(0, i);
            if (isPalindrome(stringToBeChecked)) {
                recentResult.add(stringToBeChecked);
                partitionHelper(string.substring(i), recentResult);
                recentResult.remove(recentResult.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String string) {
        int i = 0;
        int j = string.length() - 1;
        while (i < j) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "cbbbcc";
        List<List<String>> results = new Solution().partition(s);
        for (List<String> result: results) {
            System.out.println(result);
        }
    }
}
