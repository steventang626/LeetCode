import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator1 implements Iterator<Integer> {
    private Stack<NestedInteger> stack;

    public NestedIterator1(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.empty()) {
            NestedInteger top = stack.peek();
            if(top.isInteger()) return true;
            stack.pop();
            List<NestedInteger> list = top.getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }
        return false;
    }

    public static void main(String args[]) {
//        NestedIterator2 i = new NestedIterator2(nestedList);
//        while (i.hasNext()) v[f()] = i.next();
    }
}