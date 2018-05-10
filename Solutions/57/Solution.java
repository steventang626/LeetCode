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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        int j = 0;
        for (j = 0; j < intervals.size(); j++) {
            if(newInterval.start <= intervals.get(j).start){
                intervals.add(j, newInterval);
                break;
            }
        }
        if(newInterval.start > intervals.get(intervals.size()-1).start) intervals.add(j, newInterval);

        int i = Math.max(0,j-1);
        while(intervals.size() >= i+2 && i <= j){
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
        a.add(new Interval(1,3));
        a.add(new Interval(6,9));
        //a.add(new Interval(3,5));
//        a.add(new Interval(15,18));
        List<Interval> result = new Solution().insert(a,new Interval(2,5));
        for (Interval i: result) {
            System.out.println(i.start + " " + i.end);
        }
    }
}
