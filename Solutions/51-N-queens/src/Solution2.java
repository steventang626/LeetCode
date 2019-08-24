import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private boolean[] columns, diagonals1, diagonals2;
    private List<List<String>> results;
    private List<Integer> positions;
    public List<List<String>> solveNQueens(int n) {
        results = new ArrayList<>();
        positions = new ArrayList<>();
        columns = new boolean[n];
        diagonals1 = new boolean[2 * n - 1];
        diagonals2 = new boolean[2 * n - 1];
        solve(0, n);
        return results;
    }

    private void solve(int i, int n) {
        if (i == n) {
            putIntoResults(n);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (checkValid(i, j, n)) {
                columns[j] = true;
                diagonals1[i + j] = true;
                diagonals2[i - j + n - 1] = true;
                positions.add(j);
                solve(i + 1, n);
                columns[j] = false;
                diagonals1[i + j] = false;
                diagonals2[i - j + n - 1] = false;
                positions.remove(positions.size() - 1);
            }
        }
    }

    private void putIntoResults(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int position = positions.get(i);
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == position) {
                    line.append("Q");
                } else {
                    line.append(".");
                }
            }
            result.add(line.toString());
        }
        results.add(result);
    }

    private boolean checkValid(int i, int j, int n) {
        return (!columns[j] && !diagonals1[i + j] && !diagonals2[i - j + n - 1]);
    }

    public static void main(String[] args){
        int a = 4;
        List<List<String>> result = new Solution().solveNQueens(a);
        for (List<String> strings : result) {
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println();
        }
    }
}
