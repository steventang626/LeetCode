import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        int index = 0;
        if (s.length() < 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int result = 0, num = 0, last = 0;
        char sign = '+';
        while (index < s.length()) {
            char recent = s.charAt(index);
            if (Character.isDigit(recent)) {
                num = num * 10 + recent - '0';
            }
            if ((!Character.isDigit(recent) && recent != ' ') || (index == s.length() - 1)){
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        last = stack.pop();
                        stack.push(last * num);
                        break;
                    case '/':
                        last = stack.pop();
                        stack.push(last / num);
                        break;
                }
                sign = recent;
                num = 0;
            }
            index++;
        }
        if (!stack.empty()) {
            for (int number : stack) {
                result += number;
            }
        }
        return result;
    }

    public int calculate2(String s) {
        int index = 0;
        Character[] signs = {'+', '-', '*', '/'};
        Set<Character> signSet = new HashSet<>(Arrays.asList(signs));
        Stack<Integer> stack = new Stack<>();
        int result = 0, num = 0, last = 0;
        char sign = '+';
        while (index < s.length()) {
            char recent = s.charAt(index);
            if (Character.isDigit(recent)) {
                num = num * 10 + recent - '0';
            }
            if (signSet.contains(recent) || (index == s.length() - 1)){
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        last = stack.pop();
                        stack.push(last * num);
                        break;
                    case '/':
                        last = stack.pop();
                        stack.push(last / num);
                        break;
                }
                sign = recent;
                num = 0;
            }
            index++;
        }
        if (!stack.empty()) {
            for (int number : stack) {
                result += number;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = " 3/2 ";
        System.out.println(new Solution().calculate(s));
    }
}
