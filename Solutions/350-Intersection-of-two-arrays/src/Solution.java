import java.util.*;

public class Solution {

    // Time O(len(nums1) + len(nums2))
    // Space O(len(nums1))
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mapNums1 = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        // O(len(nums1))
        for (int i : nums1) {
            if (mapNums1.containsKey(i))
                mapNums1.put(i, mapNums1.get(i) + 1);
            else
                mapNums1.put(i, 1);
        }

        // O(len(nums2))
        for (int j : nums2) {
            if (mapNums1.containsKey(j) && mapNums1.get(j) > 0) {
                resultList.add(j);
                mapNums1.put(j, mapNums1.get(j) - 1);
                if (mapNums1.get(j) == 0) mapNums1.remove(j);
            }
        }
        int[] result = new int[resultList.size()];
        int k = 0;
        for (int i : resultList) {
            result[k++] = i;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5,9};
        int[] nums2 = new int[]{9,4,8,5,9};
        int[] result = new Solution().intersect(nums1, nums2);
        for (int i : result) System.out.print(i + " ");
    }
}
