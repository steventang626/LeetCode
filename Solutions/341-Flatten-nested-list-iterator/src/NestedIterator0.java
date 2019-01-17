import java.util.Iterator;
import java.util.List;
import java.util.Stack;

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator0 implements Iterator<Integer> {
    private Stack<NestedInteger> stack;

    public NestedIterator0(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        NestedInteger top = stack.pop();
        if (top == null) return null;
        else {
            return top.getInteger();
        }
    }

    @Override
    public boolean hasNext() {
        if(stack.empty()) return false;
        NestedInteger top = stack.peek();
        if(top.isInteger()) return true;
        while (!top.isInteger()) {
            stack.pop();
            List<NestedInteger> list = top.getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
            if(stack.empty()) return false;
            top = stack.peek();
        }
        return true;
    }

    public static void main(String args[]) {
//        NestedIterator2 i = new NestedIterator2(nestedList);
//        while (i.hasNext()) v[f()] = i.next();
    }
}