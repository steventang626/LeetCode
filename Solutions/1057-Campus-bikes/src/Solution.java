import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class MyComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[2] == o2[2]) {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        } else {
            return o1[2] - o2[2];
        }
    }
}

public class Solution {
    // Using bucket sort, Time O(mn), Space O(mn)
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<int[]>[] sortedDistances = new List[1999];
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int distance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                if (sortedDistances[distance] == null) {
                    sortedDistances[distance] = new ArrayList<>();
                }
                sortedDistances[distance].add(new int[]{i, j});
            }
        }
        int[] result = new int[workers.length];
        Arrays.fill(result, -1);
        Set<Integer> usedBikes = new HashSet<>();
        int assigned = 0;
        for (int i = 0; i < sortedDistances.length && assigned < workers.length; i++) {
            if (sortedDistances[i] == null) {
                continue;
            }
            for (int[] pair : sortedDistances[i]) {
                if (result[pair[0]] == -1 && !usedBikes.contains(pair[1])) {
                    result[pair[0]] = pair[1];
                    usedBikes.add(pair[1]);
                    assigned++;
                }
            }
        }
        return result;
    }

    // Use general sort, Time O(mnlog(mn)), Space O(mn)
    public int[] assignBikes2(int[][] workers, int[][] bikes) {
        List<int[]> workerBikePairs = new ArrayList<>();
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int distance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                workerBikePairs.add(new int[]{i, j, distance});
            }
        }
        workerBikePairs.sort(new MyComparator());
        int[] result = new int[workers.length];
        Arrays.fill(result, -1);
        Set<Integer> usedBikes = new HashSet<>();
        int assigned = 0;
        for (int i = 0; i < workerBikePairs.size() && assigned < workers.length; i++) {
            int[] recent = workerBikePairs.get(i);
            if (result[recent[0]] == -1 && !usedBikes.contains(recent[1])) {
                result[recent[0]] = recent[1];
                usedBikes.add(recent[1]);
                assigned++;
            }
        }
        return result;
    }

    // Use heap, Time O(mnlog(mn)), Space O(mn)
    public int[] assignBikes3(int[][] workers, int[][] bikes) {
        // List<int[]> workerBikePairs = new ArrayList<>();
        PriorityQueue<int[]> workerBikeHeap = new PriorityQueue<>(new MyComparator());
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int distance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                workerBikeHeap.add(new int[]{i, j, distance});
            }
        }
        int[] result = new int[workers.length];
        Arrays.fill(result, -1);
        Set<Integer> usedBikes = new HashSet<>();
        int assigned = 0;
        while (!workerBikeHeap.isEmpty() && assigned < workers.length) {
            int[] recent = workerBikeHeap.poll();
            if (result[recent[0]] == -1 && !usedBikes.contains(recent[1])) {
                result[recent[0]] = recent[1];
                usedBikes.add(recent[1]);
                assigned++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
	    int[][] workers = {{0, 0}, {2, 1}};
        int[][] bikes = {{1, 2}, {3, 3}};
        int[] result = new Solution().assignBikes3(workers, bikes);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
