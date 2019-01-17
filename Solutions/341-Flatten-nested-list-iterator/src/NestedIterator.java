import java.util.*;

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
                if (x.isInteger())
                    return lists.peek().previous() == x;
                lists.push(x.getList().listIterator());
            }
        }
        return false;
    }


}