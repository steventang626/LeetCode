public class Solution {
    // Time complexity O(n)
    // Space complexity O(1)
    public int[] twoSum(int[] numbers, int target) {
        //assert (numbers.length >= 2);

        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println("The input has no solution");
        return result;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{1};
        int[] result = new Solution().twoSum(numbers, 6);
        System.out.println(result[0] + " " +result[1]);
    }
}
