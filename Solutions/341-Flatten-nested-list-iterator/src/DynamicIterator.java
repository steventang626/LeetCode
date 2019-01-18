import java.util.*;

// Not fully dynamic, just can deal with set(), but remove() and add() can only be operated after the iterator cursor.
public class DynamicIterator implements Iterator<Integer> {
    int cursor;       // index of next element to return
    int lastRet = -1; // index of last element returned; -1 if no such
    List<Integer> list;

    public DynamicIterator(List<Integer> integerList) {
        list = integerList;
    }

    public Integer next() {
        int i = cursor;
        if (i >= list.size())
            throw new NoSuchElementException();
        cursor = i + 1;
        return list.get(lastRet = i);
    }

    public boolean hasNext() {
        return cursor != list.size();
    }

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        DynamicIterator iter = new DynamicIterator(list);
        //Iterator iter = list.listIterator();
        System.out.println("List elements : ");
        System.out.print(iter.next() + " ");
        System.out.print(iter.next() + " ");
        //System.out.print(iter.next() + " ");
        list.remove(2);

        System.out.println();
        for(int i : list) {
            System.out.print(i + ", ");
        }
        System.out.println();

        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
    }
}
