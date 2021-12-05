public class Solution2 {

    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            assert (num >= 0 && num <= 2);
            count[num]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {2, 2, 0, 1, 1};
        new Solution2().sortColors(nums);
        for (int i:nums) {
            System.out.print(i + " ");
        }
    }
}
