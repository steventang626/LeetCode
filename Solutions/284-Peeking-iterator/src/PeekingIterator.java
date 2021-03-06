import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {
    private boolean hasPeeked;
    private Integer peek;
    private final Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        hasPeeked = false;
        peek = null;
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasPeeked) {
            peek = iterator.next();
            hasPeeked = true;
        }
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (hasPeeked) {
            Integer result = peek;
            hasPeeked = false;
            peek = null;
            return result;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
//        if (hasPeeked) {
//            return true;
//        } else {
//            return iterator.hasNext();
//        }
        // Above is correct, but we can use one line:
        return hasPeeked || iterator.hasNext();
    }

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PeekingIterator iter = new PeekingIterator(list.iterator());
        System.out.println("List elements : ");
        System.out.print(iter.next() + " ");
        System.out.print(iter.peek() + " ");
        System.out.print(iter.next() + " ");
        System.out.print(iter.next() + " ");
        System.out.print(iter.hasNext() + " ");
    }
}
