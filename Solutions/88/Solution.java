public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        int last_1 = m - 1;
        int last_2 = n - 1;
        while(last_1 >= -1 && last_2 >= -1){
            if(last_2 == -1) return;
            if(last_1 == -1){
                for(int i = last_2; i >= 0; i--){
                    nums1[i] = nums2[i];
                }
                return;
            }
            if(nums1[last_1] <= nums2[last_2]){
                nums1[last] = nums2[last_2];
                last_2--;
            }else{
                nums1[last] = nums1[last_1];
                last_1--;
            }
            last--;
        }
    }
    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new Solution().merge(nums1, 3, nums2, 3);
        for(int i = 0; i < 6; i++){
            System.out.print(nums1[i] + " ");
        }
    }
}
