public class Solution {
    public int maxDistToClosest(int[] seats) {
        int startZero = 0;
        int endZero = 0;
        int maxZero = 0;
        int recentZero = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (recentZero > 0) {
                    maxZero = Math.max(maxZero, recentZero);
                    recentZero = 0;
                }
            } else {
                recentZero++;
            }
        }
        int start = 0;
        while (start < seats.length && seats[start] == 0) {
            start++;
            startZero++;
        }
        int end = seats.length - 1;
        while (end >= 0 && seats[end] == 0) {
            end--;
            endZero++;
        }
        return Math.max(Math.max(startZero, endZero), (maxZero + 1) / 2);
    }

    public static void main(String[] args) {
        int[] seats = {1, 0, 0, 0};
        System.out.println(new Solution().maxDistToClosest(seats));
    }
}
