import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // Build the graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        Map<String, Double> node;
        for (int i = 0; i < equations.length; i++) {
            String dividend = equations[i][0];
            String divisor = equations[i][1];
            double quotient = values[i];
            if (graph.containsKey(dividend)) {
                node = graph.get(dividend);
            } else {
                node = new HashMap<>();
                graph.put(dividend, node);
            }
            node.put(divisor, quotient);

            if (graph.containsKey(divisor)) {
                node = graph.get(divisor);
            } else {
                node = new HashMap<>();
                graph.put(divisor, node);
            }
            node.put(dividend, 1.0 / quotient);
        }

        double[] results = new double[queries.length];
        // Search
        for (int i = 0; i < queries.length; i++) {
            String dividend = queries[i][0];
            String divisor = queries[i][1];
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                results[i] = -1.0;
            } else if (dividend.equals(divisor)) {
                results[i] = 1.0;
            } else {
                results[i] = dfs(graph, dividend, divisor, new HashSet<>());
            }
        }

        return results;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String begin, String end, HashSet<String> visited) {
        Map<String, Double> startNode = graph.get(begin);
        if (startNode.containsKey(end)) {
            return startNode.get(end);
        }
        visited.add(begin);
        for (String string : startNode.keySet()) {
            if (!visited.contains(string)) {
                visited.add(string);
                double recentResult = dfs(graph, string, end, visited);
                if (recentResult != -1.0) {
                    return recentResult * startNode.get(string);
                }
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a","c"}, {"c", "b"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double[] results = new Solution().calcEquation(equations, values, queries);
        for (double result : results) {
            System.out.print(result + " ");
        }
    }
}