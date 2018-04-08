import java.util.Stack;

public class Solution {
    public int longestValidParentheses1(String s) {
        // 超时
        int length = s.length();
        if(length <=1 ) return 0;
        int longest = 0;
        for(int i = 0; i <length-1; i++){
            if(s.charAt(i) == ')') continue;
            int ll = Math.max(2,longest);
            for(int j = i+ll-1; j<length; j = j + 2){
                if(s.charAt(j) == '(') continue;
                String recent = s.substring(i,j+1);
                if(isValid(recent)){
                    longest = Math.max(longest, recent.length());
                }
            }
        }
        return longest;
    }

    public int longestValidParentheses(String s) {
        int length = s.length();
        if(length <=1 ) return 0;
        int longest = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <length; i++){
            if(s.charAt(i) == '(') stack.push(i);
            else{
                if(stack.isEmpty()) start = i+1;
                else{
                    stack.pop();
                    if(stack.isEmpty()){
                        longest = Math.max(longest, i - start + 1);
                    }else{
                        longest = Math.max(longest, i - stack.peek());
                    }
                }
            }
        }
        return longest;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for(int i = 0; i < length; i++){
            char recent = s.charAt(i);
            if(recent == '('){
                stack.push(recent);
            } else {
                if(stack.isEmpty()) return false;
                if(recent == ')' && stack.peek() != '(') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        int result = new Solution().longestValidParentheses("(()))()()()()(");
        System.out.println(result);
    }
}
