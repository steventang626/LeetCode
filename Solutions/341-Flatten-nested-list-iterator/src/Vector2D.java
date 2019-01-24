import java.util.*;

public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> itrs;
    Iterator<Integer> row;

    public Vector2D(List<List<Integer>> vec2d) {
        if(vec2d == null || vec2d.size() == 0) return;
        itrs = vec2d.iterator();
        row = itrs.next().iterator();
        getNextRow();
    }

    private void getNextRow(){
        while(!row.hasNext() && itrs.hasNext()) row = itrs.next().iterator();
    }

    @Override
    public Integer next() {
        int next = row.next();
        getNextRow();
        return next;
    }

    @Override
    public boolean hasNext() {
        return row != null && row.hasNext();
    }

    public static void main(String args[]) {
        List<List<Integer>> vec2d = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        first.add(2);
        List<Integer> second = new ArrayList<>();
        second.add(3);
        vec2d.add(first);
        vec2d.add(second);
        Vector2D i = new Vector2D(vec2d);
        while (i.hasNext())
            System.out.println(i.next());
    }
}