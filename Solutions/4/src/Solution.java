import java.util.Arrays;

public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k1 = (m + n + 1) / 2, k2 = (m + n + 2) / 2;
        return (findkth(nums1,nums2,k1) + findkth(nums1,nums2,k2)) / 2.0;
    }
    public static double findkth(int[] nums1, int[] nums2, int k){
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findkth(nums2,nums1,k);
        if (m == 0) return nums2[k-1];
        if (k == 1) return Math.min(nums1[0],nums2[0]);
        int i = Math.min(m, k/2), j = Math.min(n, k/2);
        if(nums1[i-1] > nums2[j-1]) {
            return findkth(nums1, Arrays.copyOfRange(nums2,j,n),k-j);
        } else {
            return findkth(Arrays.copyOfRange(nums1,i,m), nums2,k-i);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        int[] b = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(findMedianSortedArrays(a,b));
    }
}
