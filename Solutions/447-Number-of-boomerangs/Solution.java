import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 优化了原解法
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        if (points.length <= 2) return 0;
        HashMap<Integer, Integer> distanceNum = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int distance = (points[i][1] - points[j][1]) * (points[i][1] - points[j][1])
                            + (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]);
                    Integer num = distanceNum.put(distance, distanceNum.getOrDefault(distance, 0) + 1);
                    result += (num != null ? num * 2 : 0);
                }
            }
            distanceNum.clear();
        }
        return result;
    }

    public int numberOfBoomerangs1(int[][] points) {
        int result = 0;
        if (points.length <= 2) return 0;
        HashMap<Integer, Integer> distanceNum = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int distance = (points[i][1] - points[j][1]) * (points[i][1] - points[j][1])
                            + (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]);
                    distanceNum.put(distance, distanceNum.getOrDefault(distance, 0) + 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry: distanceNum.entrySet()) {
                result += entry.getValue() * (entry.getValue() - 1);
            }
            distanceNum.clear();
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(new Solution().numberOfBoomerangs(points));
    }
}
