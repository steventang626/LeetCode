import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> setNums1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int i : nums1) setNums1.add(i);
        for (int j : nums2) {
            if (setNums1.contains(j)) resultSet.add(j);
        }
        int[] result = new int[resultSet.size()];
        int k = 0;
        for (int i : resultSet) {
            result[k++] = i;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,8,5,9};
        int[] result = new Solution().intersection(nums1, nums2);
        for (int i : result) System.out.print(i + " ");
    }
}
