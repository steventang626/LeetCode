import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        int length = heights.length;
        if(length == 0) return 0;
        if(length == 1) return heights[0];

        int min = heights[0];
        int num = 0;
        int max = heights[0];
        for(int i = 0; i < heights.length; i++){
            if(heights[i] < min){
                min = heights[i];
                num = i;
            }
            if(heights[i] > min){
                max = heights[i];
            }
        }
        if(max == min) return length * min;

        int r1 = length * min;
        int r2 = 0;
        int r3 = 0;
        if(num == 0){
            r3 = largestRectangleArea(Arrays.copyOfRange(heights, 1, length));
        }else if(num == length - 1){
            r2 = largestRectangleArea(Arrays.copyOfRange(heights, 0, length-1));
        }else{
            r3 = largestRectangleArea(Arrays.copyOfRange(heights, num + 1, length));
            r2 = largestRectangleArea(Arrays.copyOfRange(heights, 0, num));
        }
        return Math.max(r1, Math.max(r2, r3));
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6};
        System.out.print(new Solution().largestRectangleArea(a));
    }
}
