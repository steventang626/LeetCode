import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums){
        if(nums.length == 0) return null;
        List<List<Integer>> l1_1 = new ArrayList<>();
        List<Integer> l1_2 = new ArrayList<>();
        l1_2.add(nums[0]);
        l1_1.add(l1_2);
        if(nums.length == 1) return l1_1;
        List<List<Integer>> recent_result = permute(Arrays.copyOfRange(nums, 1,nums.length));
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0; i<recent_result.size(); i++){
            List<Integer> recent_list = recent_result.get(i);
            for(int j = 0; j <= recent_list.size(); j++){
                List<Integer> new_list = new ArrayList<>();
                new_list.addAll(recent_list);
                new_list.add(j,nums[0]);
                result.add(new_list);
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] a = {1,2,3};
        List<List<Integer>> result = new Solution().permute(a);
        for(int i =0; i<result.size(); i++){
            List<Integer> recent = result.get(i);
            for(int j = 0; j < recent.size(); j++){
                System.out.print(recent.get(j)+" ");
            }
            System.out.println();
        }

//        List<List<Integer>> aa= new ArrayList<>();
//        List<Integer> bb = new ArrayList<>();
//        bb.add(1);
//        bb.add(2);
//        aa.add(bb);
//        bb.remove(1);
//        for(int i =0; i<aa.get(0).size(); i++){
//            int recent = aa.get(0).get(i);
//            System.out.print(recent+" ");
//        }
//        System.out.println();
////        for(int i =0; i<bb.size(); i++){
////            int recent = bb.get(i);
////            System.out.print(recent+" ");
//        }
    }
}
