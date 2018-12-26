import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i % 15 == 0) {
                result.add("FizzBuzz");
            } else if(i % 3 == 0) {
                result.add("Fizz");
            } else if(i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    public List<String> fizzBuzz2(int n) {
        List<String> result = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            StringBuilder numAnswerString = new StringBuilder();
            if(i % 3 == 0) {
                numAnswerString.append("Fizz");
            }
            if(i % 5 == 0) {
                numAnswerString.append("Buzz");
            }
            if(numAnswerString.length() == 0) {
                numAnswerString.append(i);
            }
            result.add(numAnswerString.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = new Solution().fizzBuzz2(16);
        for(String str: result) {
            System.out.println(str);
        }
    }
}
