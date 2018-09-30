import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<String> letterCombinations(String digits) {
        List<String> lc = new ArrayList<>();
        String[] strings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

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
    public static void main(String[] args){
        System.out.println(letterCombinations("23"));
    }
}
