import java.util.*;

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
    private Integer i;
    private List<NestedInteger> list;

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
    private List<NestedInteger> list;
    private int next_times;

    public NestedIterator0(List<NestedInteger> nestedList) {
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
        next_times++;
        return stack.pop().getInteger();
    }

    public void next_helper() {
        if (hasNext_helper()) {
            stack.pop();
        }
    }

    public boolean hasNext_helper() {
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

    @Override
    public boolean hasNext() {
        if(stack.empty()) return false;
        stack.removeAllElements();
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
        for(int i = 0; i < next_times; i++) {
            next_helper();
        }
        return hasNext_helper();
    }

//    static int num = 0;
//
//    public static int f() {
//        return num++;
//    }

    public static void main(String args[]) {
        List<NestedInteger> nestedList = new ArrayList<>();
        List<NestedInteger> first = new ArrayList<>();
        first.add(new NestedInteger(1));
        first.add(new NestedInteger(2));
        nestedList.add(new NestedInteger(first));
        nestedList.add(new NestedInteger(3));
        nestedList.add(new NestedInteger(4));

//        Integer[] v = new Integer[6];
        NestedIterator0 i = new NestedIterator0(nestedList);
//        while (i.hasNext()) v[f()] = i.next();

        if (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        if (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
//        i.hasNext();
//        System.out.println(i.stack.peek().getInteger());
//        i.hasNext();
//        System.out.println(i.stack.peek().getInteger());

//        System.out.println("Here " + i.next() + " ");
//
//        System.out.println("List length: " + i.list.size());
        nestedList.add(1, new NestedInteger(5));
        nestedList.remove(3);
        nestedList.set(2, new NestedInteger(6));

//        System.out.println("List length: " + i.list.size());

        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();

//        NestedIterator0 i2 = new NestedIterator0(nestedList);
//        while (i2.hasNext()) {
//            System.out.print(i2.next() + " ");
//        }
    }
}