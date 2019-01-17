import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestIterator {
    public void original() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator iter = list.iterator();
        System.out.println("List elements : ");

        while (iter.hasNext())
            System.out.print(iter.next() + " ");
    }

    public void dynamic() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator iter = list.iterator();
        System.out.println("List elements : ");
        System.out.print(iter.next() + " ");
        System.out.print(iter.next() + " ");
        //list.add(3, 5);
        list.remove(2);

        System.out.println();
        for(int i : list) {
            System.out.print(i + ", ");
        }
        System.out.println();

        if (iter.hasNext()) {
            System.out.println("Here");
            System.out.print(iter.next() + " ");
        }
    }

    public void dynamic2() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator iter = list.listIterator();
        System.out.println("List elements : ");
        System.out.print(iter.next() + " ");
        System.out.print(iter.next() + " ");
        //System.out.print(iter.next() + " ");

        ((ListIterator) iter).add(6);
        //iter.remove();
//        ((ListIterator) iter).set(5);
        //((ListIterator) iter).previous();
//        list.set(2,5);
        //list.remove(2);

        System.out.println();
        for(int i : list) {
            System.out.print(i + ", ");
        }
        System.out.println();

        if (iter.hasNext()) {
            System.out.println("Here");
            System.out.print(iter.next() + " ");
        }
    }

    public void dynamic3() {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator iter = list.listIterator();
        System.out.println("List elements : ");
        System.out.print(iter.next() + " ");
        System.out.print(iter.next() + " ");
        //System.out.print(iter.next() + " ");

//        ((ListIterator) iter).add(5);
        //iter.remove();
        list.add(2,5);
        list.set(2,5);
//        list.remove(2);

        System.out.println();
        for(int i : list) {
            System.out.print(i + ", ");
        }
        System.out.println();

        if (iter.hasNext()) {
            System.out.println("Here");
            System.out.print(iter.next() + " ");
        }

        if (iter.hasNext()) {
            System.out.println("Here");
            System.out.print(iter.next() + " ");
        }
    }

    public static void main(String args[]) {
        //new TestIterator().original();
        //new TestIterator().dynamic();
        new TestIterator().dynamic2();
        //new TestIterator().dynamic3();
    }
}
