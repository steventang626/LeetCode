import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

interface NestedIntegerInterface {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedInteger implements NestedIntegerInterface {
    public Integer i;
    public List<NestedInteger> list;

    public NestedInteger(Integer integer) {
        i = integer;
    }

    public NestedInteger(List<NestedInteger> listNestedInteger) {
        list = listNestedInteger;
    }

    public boolean isInteger(){
        return list == null;
    }

    public Integer getInteger() {
        if(isInteger()) {
            return i;
        } else {
            return null;
        }
    }

    public List<NestedInteger> getList() {
        if(isInteger()) {
            return null;
        } else {
            return list;
        }
    }
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
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
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
        List<NestedInteger> nestedList = new ArrayList<>();
        List<NestedInteger> first = new ArrayList<>();
        first.add(new NestedInteger(1));
        first.add(new NestedInteger(2));
        nestedList.add(new NestedInteger(first));
        nestedList.add(new NestedInteger(3));
        nestedList.add(new NestedInteger(4));

        NestedIterator0 i = new NestedIterator0(nestedList);
        i.hasNext();
        System.out.println(i.stack.peek().getInteger());
        i.hasNext();
        System.out.println(i.stack.peek().getInteger());

        System.out.println("Here" + i.next() + " ");

        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }

    }
}