import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
    class startComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.start, o2.start);
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals,new startComparator());
        int i = 0;
        while(intervals.size() >= i+2){
            if(intervals.get(i+1).start <= intervals.get(i).end){
                intervals.set(i, new Interval(intervals.get(i).start, Math.max(intervals.get(i+1).end, intervals.get(i).end)));
                intervals.remove(i+1);
            }else{
                i++;
            }
        }
        return intervals;
    }
    public static void main(String[] args){
        List<Interval> a = new ArrayList<>();
        a.add(new Interval(1,4));
        a.add(new Interval(0,2));
        a.add(new Interval(3,5));
//        a.add(new Interval(15,18));
        List<Interval> result = new Solution().merge(a);
        for (Interval i: result) {
            System.out.println(i.start + " " + i.end);
        }
    }
}
