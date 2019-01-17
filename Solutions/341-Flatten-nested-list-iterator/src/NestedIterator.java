import java.util.*;

// Idempotent
public class NestedIterator implements Iterator<Integer> {
    private Stack<ListIterator<NestedInteger>> lists;

    public NestedIterator(List<NestedInteger> nestedList) {
        lists = new Stack<>();
        lists.push(nestedList.listIterator());
    }

    public Integer next() {
        if(hasNext()) {
            return lists.peek().next().getInteger();
        } else {
            throw new NoSuchElementException();
        }
    }

    public boolean hasNext() {
        while (!lists.empty()) {
            if (!lists.peek().hasNext()) {
                lists.pop();
            } else {
                NestedInteger x = lists.peek().next();
                if (x.isInteger()){
                    lists.peek().previous();
                    return true;
                }
                // 同下句
                //return lists.peek().previous() == x;
                lists.push(x.getList().listIterator());
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

        NestedIterator i = new NestedIterator(nestedList);

        System.out.println("Here " + i.next() + " ");
        System.out.println("Here " + i.next() + " ");
        System.out.println("Here " + i.next() + " ");

        while (i.hasNext())
            System.out.print(i.next() + " ");
    }
}