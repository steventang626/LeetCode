import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    class Point {
        int x;
        int y;
        int squareDistance;
        Point (int x, int y) {
            this.x = x;
            this.y = y;
            squareDistance = x * x + y * y;
        }
    }

    class PointComparator implements Comparator<Point> {
        @Override
        public int compare(Point one, Point two) {
            return one.squareDistance - two.squareDistance;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        List<Point> list = new ArrayList<>();
        int[][] result = new int[K][2];
        for (int i = 0; i < points.length; i++) {
            list.add(new Point(points[i][0], points[i][1]));
        }
        list.sort(new PointComparator());
        for (int i = 0; i < K; i++) {
            result[i][0] = list.get(i).x;
            result[i][1] = list.get(i).y;
        }
        return result;
    }

    int[][] globalPoints;
    public int[][] kClosest2(int[][] points, int K) {
        globalPoints = points;
        sort(0, points.length - 1, K);
        return Arrays.copyOfRange(globalPoints, 0, K);
    }

    private void sort(int start, int end, int K) {
        if (end <= start) {
            return;
        }
        int mid = partition(start, end);
        if (mid > K - 1) {
            sort(start, mid - 1, K);
        } else {
            sort(mid + 1, end, K);
        }
    }

    private int partition(int start, int end) {
        int i = start;
        int j = end;
        int distance = distance(globalPoints[start]);
        while (i < j) {
            while (i < j && distance(globalPoints[j]) >= distance) {
                j--;
            }
            while (i < j && distance(globalPoints[i]) <= distance) {
                i++;
            }
            swap(i, j);
        }
        swap(start, i);
        return i;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int first, int second) {
        int[] temp = globalPoints[first];
        globalPoints[first] = globalPoints[second];
        globalPoints[second] = temp;
    }

    public static void main(String[] args) {
        int[][] points = new int[3][2];
        points[0][0] = 3;
        points[0][1] = 3;
        points[1][0] = 5;
        points[1][1] = -1;
        points[2][0] = -2;
        points[2][1] = 4;
        int[][] result = new Solution().kClosest2(points, 2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }
}
