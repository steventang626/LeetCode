import java.util.*;

public class NestedIterator1 implements Iterator<Integer> {
    private Stack<NestedInteger> stack;
    private List<NestedInteger> list;
    private int next_counter;

    public NestedIterator1(List<NestedInteger> nestedList) {
        list = nestedList;
        stack = new Stack<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        next_counter++;
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        if(stack.empty()) return false;
        stack.removeAllElements();
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
        for(int i = 0; i < next_counter; i++) {
            next_helper();
        }
        return hasNext_helper();
    }

    public void next_helper() {
        if (hasNext_helper()) {
            stack.pop();
        }
    }

    public boolean hasNext_helper() {
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
        List<NestedInteger> nestedList = new ArrayList<>();
        List<NestedInteger> first = new ArrayList<>();
        first.add(new NestedInteger(1));
        first.add(new NestedInteger(2));
        nestedList.add(new NestedInteger(first));
        nestedList.add(new NestedInteger(3));
        nestedList.add(new NestedInteger(4));

        NestedIterator0 i = new NestedIterator0(nestedList);
        if (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        if (i.hasNext()) {
            System.out.print(i.next() + " ");
        }

        first.add(new NestedInteger(7));
        nestedList.set(0, new NestedInteger(first));
        nestedList.add(1, new NestedInteger(5));
        nestedList.remove(3);
        nestedList.set(2, new NestedInteger(6));

        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
    }
}