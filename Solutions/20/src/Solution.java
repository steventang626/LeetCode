import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for(int i = 0; i < length; i++){
            char recent = s.charAt(i);
            if(recent == '(' || recent == '{' || recent == '['){
                stack.push(recent);
            } else {
                if(stack.isEmpty()) return false;
                if(recent == ')' && stack.peek() != '(') return false;
                if(recent == '}' && stack.peek() != '{') return false;
                if(recent == ']' && stack.peek() != '[') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        boolean result = new Solution().isValid("(");
        System.out.println(result);
    }
}