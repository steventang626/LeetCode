public class Solution {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = (right - left) * Math.min(height[left], height[right]);
        while (left < right){
            if (height[left] < height[right]){
                left++;
            } else right--;
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
        }
        return max;
    }
    public static void main(String[] args) {
        int[] a = {1,1};
        System.out.println(maxArea(a));
    }
}
