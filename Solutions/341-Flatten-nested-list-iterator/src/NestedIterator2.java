import java.util.Iterator;
import java.util.List;

public class NestedIterator2 implements Iterator<Integer> {

    NestedIterator2 current;
    NestedInteger nextFromList;
    Iterator<NestedInteger> list;

    public NestedIterator2(List<NestedInteger> nestedList) {
        nextFromList = null;
        list = nestedList.iterator();
        current = null;
    }

    @Override
    public Integer next() {
        while (current == null || !current.hasNext()) {
            NestedInteger next = nextFromList != null ? nextFromList : list.next();
            nextFromList = null;
            if (next.isInteger()) {
                return next.getInteger();
            } else {
                current = new NestedIterator2(next.getList());
            }
        }
        return current.next();
    }

    @Override
    public boolean hasNext() {
        if (current != null && current.hasNext()) {
            return true;
        }
        while (list.hasNext() || nextFromList != null) {
            if (nextFromList == null) {
                nextFromList = list.next();
            }
            if (nextFromList.isInteger())
                return true;
            if (new NestedIterator2(nextFromList.getList()).hasNext())
                return true;
            nextFromList = null;
        }
        return false;
    }
}