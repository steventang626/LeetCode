import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<String> genarateParenthesis(int n) {
        List<String> p = new ArrayList<>();
        List<String> q = genarate(n, n);
        for (String str:q) {
            //System.out.println(str);
            if(isValid(str)) p.add(str);
        }
        return p;
    }

    public List<String> genarate(int n){
        // 生成所有n位由"("")"构成的字符串
        List<String> p = new ArrayList<>();
        if(n == 1){
            p.add("(");
            p.add(")");
            return p;
        } else {
            List<String> q = genarate(n - 1);
            int size = q.size();
            for(int i = 0; i < size; i++){
                p.add(q.get(i) + "(");
                p.add(q.get(i) + ")");
            }
            return p;
        }
    }

    public List<String> genarate(int m, int n){
        // 生成m个"(", n个")"构成的字符串
        List<String> p = new ArrayList<>();
        if(m == 0){
            String str = "";
            for(int i = 0; i<n; i++){
                str += ")";
            }
            p.add(str);
            return p;
        }else if(n==0){
            String str = "";
            for(int i = 0; i<m; i++){
                str += "(";
            }
            p.add(str);
            return p;
        }
        List<String> q = genarate(m-1,n);
        for (String str:q) {
            p.add(str + "(");
        }
        List<String> r = genarate(m,n-1);
        for (String str:r) {
            p.add(str + ")");
        }
        return p;
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
        List<String> result = new Solution().genarateParenthesis(3);
        System.out.println(result);
    }
}
