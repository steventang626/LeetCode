import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> courseQueue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                courseQueue.add(i);
            }
        }
        int index = 0;
        int[] result = new int[numCourses];
        while (!courseQueue.isEmpty()) {
            int recent = courseQueue.poll();
            result[index++] = recent;
            for (int neigh : graph.getOrDefault(recent, new ArrayList<>())) {
                inDegree[neigh]--;
                if (inDegree[neigh] == 0) {
                    courseQueue.add(neigh);
                }
            }
        }
        return index == numCourses ? result : new int[0];
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] pre = {{1, 0}};
        int[] result = new Solution().findOrder(numCourses, pre);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
