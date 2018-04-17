import java.util.HashMap;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        // 可通过测试用例
        int length = nums.length;
        int[] all = new int[1000000];
        for(int i = 0; i < length; i++){
            if(nums[i]>0){
                all[nums[i]] = 1;
            }
        }
        for(int j = 1; j < 1000000; j++){
            if(all[j] == 0){
                return j;
            }
        }
        return length+1;
    }

    public int firstMissingPositive2(int[] nums) {
        // 将1中数组换位哈希表，但都不是常数空间
        int length = nums.length;
        HashMap<Integer,Integer> all = new HashMap<>();
        for(int i = 0; i < length; i++){
            if(nums[i]>0){
                all.put(nums[i],1);
            }
        }
        for(int j = 1; j <= length; j++){
            if(!all.containsKey(j)){
                return j;
            }
        }
        return length+1;
    }

    public int firstMissingPositive3(int[] nums) {
        int length = nums.length;
        int i = 0;
        while(i<length){
            if(nums[i]>0 && nums[i] <= length && nums[i] != i+1 && nums[i] != nums[nums[i] - 1]){
                int j = nums[i];
                nums[i] = nums[j-1];
                nums[j-1] = j;
            }else{
                i++;
            }
        }
        for(int j = 0; j < length; j++){
            if(nums[j] != j+1){
                return j+1;
            }
        }
        return length+1;
    }
    public static void main(String[] args){
        int[] a = {1,2,3};
        int result = new Solution().firstMissingPositive2(a);
        System.out.print(result);
    }
}
