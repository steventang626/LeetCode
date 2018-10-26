import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        int num1;
        int num2;
        for(int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                num2 = numbers.pop();
                num1 = numbers.pop();
                switch (tokens[i]) {
                    case "+":
                        numbers.push(num1 + num2);
                        break;
                    case "-":
                        numbers.push(num1 - num2);
                        break;
                    case "*":
                        numbers.push(num1 * num2);
                        break;
                    case "/":
                        numbers.push(num1 / num2);
                        break;
                }
            } else {
                numbers.push(Integer.valueOf(tokens[i]));
            }
        }
        return numbers.pop();
    }
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(new Solution().evalRPN(tokens));
    }
}
