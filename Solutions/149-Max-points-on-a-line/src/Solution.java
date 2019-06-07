import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class Solution {
    public int maxPoints(Point[] points) {
        int result = 0;
        if (points.length <= 2) return points.length;
        HashMap<HashMap<Integer, Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int verticle = 0;
            int duplicate = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    duplicate++;
                } else if (points[i].x == points[j].x){
                    verticle++;
                } else {
                    int dy = points[j].y - points[i].y;
                    int dx = points[j].x - points[i].x;
                    int gcd = gcd(dy, dx);
                    HashMap<Integer, Integer> m = new HashMap<>();
                    m.put(dx / gcd, dy / gcd);
                    map.put(m, map.getOrDefault(m, 0) + 1);
                }
            }

            result = Math.max(result, verticle + duplicate);
            for(Map.Entry<HashMap<Integer, Integer>, Integer> entry : map.entrySet()) {
                result = Math.max(result, entry.getValue() + duplicate);
            }
            map.clear();
        }
        return result + 1;
    }

    private int gcd (int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    // 使用BigDecimal，较慢
    public int maxPoints1(Point[] points) {
        int result = 0;
        if (points.length <= 2) return points.length;
        HashMap<BigDecimal, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int verticle = 0;
            int duplicate = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    duplicate++;
                } else if (points[i].x == points[j].x){
                    verticle++;
                } else {
                    BigDecimal k = div((points[j].y - points[i].y) * 1.0, (points[j].x - points[i].x) * 1.0, 20);
                    map.put(k, map.getOrDefault(k, 0) + 1);
                }
            }

            result = Math.max(result, verticle + duplicate);
            for(Map.Entry<BigDecimal, Integer> entry : map.entrySet()) {
                result = Math.max(result, entry.getValue() + duplicate);
            }
            map.clear();
        }
        return result + 1;
    }

    public BigDecimal div(double d1,double d2,int len) {// 进行除法运算
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.divide(b2,len,BigDecimal.ROUND_HALF_UP);
    }

    public static void main(String[] args) {
        Point[] p = new Point[]{new Point(1,1), new Point(5,3),new Point(3,2),new Point(4,1),new Point(2,3),new Point(1,4)};
        System.out.println(new Solution().maxPoints(p));
        Point[] p1 = new Point[]{new Point(2,3), new Point(3,3),new Point(-5,3)};
        System.out.println(new Solution().maxPoints(p1));

//        int dy = -3;
//        int dx = -15;
//        int gcd = new Solution().gcd(dy, dx);
//        System.out.println(gcd);
//        System.out.println(dx / gcd);
//        System.out.println(dy / gcd);

//        System.out.println(new Solution().div(94911150.0 , 94911151.0, 100));
//        System.out.println(new Solution().div(94911151.0 , 94911152.0, 100));
//        System.out.println(94911151 * 1.0 / 94911152);
    }
}
