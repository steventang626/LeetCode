import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> smallQ;
    PriorityQueue<Integer> bigQ;

    public MedianFinder() {
        smallQ = new PriorityQueue<>(Collections.reverseOrder());
        bigQ = new PriorityQueue<>();
    }

    public void addNum(int num) {
        smallQ.add(num);
        bigQ.add(smallQ.peek());
        smallQ.poll();
        if (bigQ.size() > smallQ.size()) {
            smallQ.add(bigQ.peek());
            bigQ.poll();
        }
    }

    public double findMedian() {
        if (bigQ.size() == smallQ.size()) {
            return 0.5 * (smallQ.peek() + bigQ.peek());
        } else {
            return smallQ.peek();
        }
    }

    public static void main(String[] args) {
    	MedianFinder obj = new MedianFinder();
    	obj.addNum(1);
    	System.out.println(obj.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */