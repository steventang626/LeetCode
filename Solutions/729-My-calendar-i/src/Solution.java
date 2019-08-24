import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

class MyCalendar {
    private List<Pair<Integer, Integer>> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        Pair<Integer, Integer> newPair = new Pair<>(start, end);
        for (Pair<Integer, Integer> pair : bookings) {
            if (hasDoubleBooking(pair, newPair)) {
                return false;
            }
        }
        bookings.add(newPair);
        return true;
    }

    private boolean hasDoubleBooking(Pair<Integer, Integer> pair1, Pair<Integer, Integer> pair2) {
        return !(pair1.getValue() <= pair2.getKey() || pair2.getValue() <= pair1.getKey());
    }
}

class MyCalendar2 {
    private List<int[]> bookings;

    public MyCalendar2() {
        bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] pair : bookings) {
            if (start < pair[1] && end > pair[0]) {
                return false;
            }
        }
        bookings.add(new int[]{start, end});
        return true;
    }
}

public class Solution {
    public static void main(String[] args) {
        MyCalendar2 obj = new MyCalendar2();
        System.out.println(obj.book(10, 20));
        System.out.println(obj.book(15, 25));
        System.out.println(obj.book(20, 30));
    }
}
