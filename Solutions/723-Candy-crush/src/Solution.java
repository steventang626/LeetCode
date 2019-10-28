public class Solution {
    public int[][] candyCrush(int[][] board) {
        return null;
    }

    public static void main(String[] args) {
	    int[][] board = {{110, 5, 112, 113, 114}, {210, 211, 5, 213, 214}, {310, 311, 3, 313, 314},
                {410, 411, 412, 5, 414}, {5, 1, 512, 3, 3}, {610, 4, 1, 613, 614}, {710, 1, 2, 713, 714},
                {810, 1, 2, 1, 1}, {1, 1, 2, 2, 2}, {4, 1, 4, 4, 1014}};
	    int[][] result = new Solution().candyCrush(board);
	    for (int[] row : result) {
	        for (int num : row) {
	            System.out.print(num + " ");
            }
        }
    }
}
