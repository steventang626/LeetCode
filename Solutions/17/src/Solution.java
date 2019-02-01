import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private String[] strings = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> lc = new ArrayList<>();
        int length = digits.length();
        if(length == 0) return lc;
        if(length == 1){
            for (int i=0;i<strings[digits.charAt(0) - 48].length(); i++){
                lc.add(String.valueOf(strings[digits.charAt(0) - 48].charAt(i)));
            }
            return lc;
        } else {
            List<String> ls = letterCombinations(digits.substring(1,length));
            for(int i = 0; i<ls.size();i++){
                for (int j=0; j<strings[digits.charAt(0) - 48].length(); j++){
                    lc.add(String.valueOf(strings[digits.charAt(0) - 48].charAt(j)) + ls.get(i));
                }
            }
            return lc;
        }
    }

    private List<String> result;

    public List<String> letterCombinations2(String digits) {
        result = new ArrayList<>();
        if (digits.length() > 0) {
            findCombination(digits, 0, "");
        }
        return result;
    }

    private void findCombination(String digits, int index, String recentString) {
        if (index == digits.length()) {
            result.add(recentString);
            return;
        }
        char recent = digits.charAt(index);
        String string = strings[recent - '0'];
        for (int i = 0; i < string.length(); i++) {
            findCombination(digits, index + 1, recentString + string.charAt(i));
        }

    }

    public static void main(String[] args){
        System.out.println(new Solution().letterCombinations2("23"));
    }
}
