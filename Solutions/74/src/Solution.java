public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int length = matrix[0].length;
        if(length == 0) return false;
        int start = 0;
        int end = matrix.length - 1;
        int found = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(matrix[mid][0] <= target && matrix[mid][length - 1] >= target){
                found = mid;
                break;
            } else if(matrix[mid][0] > target){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        if(found == -1) return false;
        else{
            int start1 = 0;
            int end1 = length - 1;
            while(start1 <= end1){
                int mid1 = start1 + (end1 - start1) / 2;
                if(matrix[found][mid1] == target){
                    return true;
                } else if(matrix[found][mid1] > target){
                    end1 = mid1 - 1;
                } else{
                    start1 = mid1 + 1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
    int[][] matrix = {{}};
        int target = 22;
        System.out.print(new Solution().searchMatrix(matrix, target));
    }
}
