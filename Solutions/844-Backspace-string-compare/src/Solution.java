import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {
    // Time O(n ^ 2), Space O(n)
    public boolean backspaceCompare(String S, String T) {
        String first = backspaceString(S);
        String second = backspaceString(T);
        return first.equals(second);
    }

    private String backspaceString(String s) {
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '#') {
                if (i == 0) {
                    s = s.substring(1);
                } else {
                    s = s.substring(0, i - 1) + s.substring(i + 1);
                    i = i - 1;
                }
            } else {
                i++;
            }
        }
        return s;
    }

    // Time O(n), Space O(n)
    public boolean backspaceCompare2(String S, String T) {
        String first = backspaceString2(S);
        String second = backspaceString2(T);
        return first.equals(second);
    }

    private String backspaceString2(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char recent = s.charAt(i);
            if (recent != '#') {
                deque.addLast(recent);
            } else if (!deque.isEmpty()) {
                deque.removeLast();
            }
        }
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            result.append(deque.pollFirst());
        }
        return String.valueOf(deque);
    }

    // Time O(n), Space O(n)
    public boolean backspaceCompare3(String S, String T) {
        return backspaceString3(S).equals(backspaceString3(T));
    }

    private String backspaceString3(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char recent = s.charAt(i);
            if (recent != '#') {
                stack.push(recent);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }

    // Time O(n), Space O(1)
    public boolean backspaceCompare4(String S, String T) {
        int indexS = S.length() - 1;
        int indexT = T.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while (indexS >= 0 || indexT >= 0) {
            while (indexS >= 0) {
                if (S.charAt(indexS) == '#') {
                    skipS++;
                    indexS--;
                } else if (skipS > 0) {
                    skipS--;
                    indexS--;
                } else {
                    break;
                }
            }
            while (indexT >= 0) {
                if (T.charAt(indexT) == '#') {
                    skipT++;
                    indexT--;
                } else if (skipT > 0) {
                    skipT--;
                    indexT--;
                } else {
                    break;
                }
            }
            if (indexS >= 0 && indexT >= 0 && S.charAt(indexS) != T.charAt(indexT)) {
                return false;
            }
            if (indexS >= 0 != indexT >= 0) {
                return false;
            }
            indexS--;
            indexT--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare4("a#c", "c"));
    }
}
