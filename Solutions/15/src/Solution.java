import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static List<List<Integer>> threeSum1(int[] nums) {
        //暴力搜索超时
        List<List<Integer>> threeSum = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i<length; i++){
            for(int j = i+1; j<length; j++){
                for(int k = j+1; k<length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> three = new ArrayList<>();
                        three.add(nums[i]);
                        three.add(nums[j]);
                        three.add(nums[k]);
                        Collections.sort(three);
                        if(!threeSum.contains(three)){
                            //System.out.println(three);
                            threeSum.add(three);
                            //System.out.println(threeSum);
                        }
                    }
                }
            }
        }
        //System.out.println(threeSum);
        return threeSum;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        //按正负分，依然超时
        List<List<Integer>> threeSum = new ArrayList<>();
        int length = nums.length;
        
        List<Integer> num = new ArrayList<>();
        for(int i = 0; i < length;i++){
            num.add(nums[i]);
        }
        Collections.sort(num);

        System.out.println(num);
        if(num.contains(0)){
            int start = num.indexOf(0);
            System.out.println(start);
            int end = num.lastIndexOf(0);
            System.out.println(end);
            if(end - start >= 2){
                List<Integer> three = new ArrayList<Integer>(Arrays.asList(0,0,0));
                if(!threeSum.contains(three)) threeSum.add(three);
                for(int i = 0; i < start;i ++){
                    if(i-1>0 && num.get(i).equals(num.get(i-1))) continue;
                    if(num.contains(-num.get(i))){
                        List<Integer> three1 = new ArrayList<Integer>(Arrays.asList(num.get(i),0,-num.get(i)));
                        if(!threeSum.contains(three1)){
                            threeSum.add(three1);
                        }
                    }
                }
            } else{
                for(int i = 0; i < start;i ++){
                    if(i-1>0 && num.get(i).equals(num.get(i-1))) continue;
                    if(num.contains(-num.get(i))){
                        List<Integer> three = new ArrayList<Integer>(Arrays.asList(num.get(i),0,-num.get(i)));
                        if(!threeSum.contains(three)) threeSum.add(three);
                    }
                }
            }
            for(int i = 0; i < start;i ++){
                if(i-1>0 && num.get(i).equals(num.get(i-1))) continue;
                for(int j = i+1;j<start;j++){
                    int twoSum = num.get(i) + num.get(j);
                    if(num.contains(-twoSum)){
                        List<Integer> three = new ArrayList<Integer>(Arrays.asList(num.get(i),num.get(j),-twoSum));
                        if(!threeSum.contains(three)) threeSum.add(three);
                    }
                }
            }
            for(int i = end+1; i < length;i ++){
                if(i-1>0 && num.get(i).equals(num.get(i-1))) continue;
                for(int j = i+1;j<length;j++){
                    int twoSum = num.get(i) + num.get(j);
                    if(num.contains(-twoSum)){
                        List<Integer> three = new ArrayList<Integer>(Arrays.asList(-twoSum,num.get(i),num.get(j)));
                        if(!threeSum.contains(three)) threeSum.add(three);
                    }
                }
            }
        }
        else {
            int firstPositive = 0;
            for(int i= 0; i<length;i++){
                if(num.get(i)>0){
                    firstPositive = i;
                    break;
                }
            }
            for(int i = 0; i < firstPositive;i ++){
                if(i-1>=0 && num.get(i).equals(num.get(i-1))) continue;
                for(int j = i+1;j<firstPositive;j++){
                    int twoSum = num.get(i) + num.get(j);
                    if(num.contains(-twoSum)){
                        List<Integer> three = new ArrayList<Integer>(Arrays.asList(num.get(i),num.get(j),-twoSum));
                        if(!threeSum.contains(three)) threeSum.add(three);
                    }
                }
            }
            for(int i = firstPositive; i < length;i ++){
                if(i-1>=0 && num.get(i).equals(num.get(i-1))) continue;
                for(int j = i+1;j<length;j++){
                    int twoSum = num.get(i) + num.get(j);
                    if(num.contains(-twoSum)){
                        List<Integer> three = new ArrayList<Integer>(Arrays.asList(-twoSum,num.get(i),num.get(j)));
                        if(!threeSum.contains(three)) threeSum.add(three);
                    }
                }
            }
        }
        return threeSum;
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        //遍历一个变量，需要注意的是get(i)返回的是Integer类型，不能用==来比较
        List<List<Integer>> threeSum = new ArrayList<>();
        int length = nums.length;
        List<Integer> num = new ArrayList<>();
        for(int i = 0; i < length;i++){
            num.add(nums[i]);
        }
        Collections.sort(num);
        for(int i = 0; i <length; i++){
            if(num.get(i) > 0) break;
            if(i>0 && num.get(i).equals(num.get(i-1))) continue;
            int j = i+1;
            int k = length-1;
            int sum = -num.get(i);
            while (j < k){
                int twoSum = num.get(j) + num.get(k);
                if(twoSum == sum){
                    List<Integer> three = new ArrayList<Integer>(Arrays.asList(-sum,num.get(j),num.get(k)));
                    threeSum.add(three);
                    while(j<k && num.get(j).equals(num.get(j+1))) j++;
                    while(j<k && num.get(k).equals(num.get(k-1))) --k;
                    j++;
                    k--;
                } else if(twoSum < sum){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return threeSum;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //遍历一个变量，数组直接排序，然后不引入List，加速很多
        List<List<Integer>> threeSum = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i <length; i++){
            if(nums[i] > 0) break;
            if(i>0 && nums[i]==(nums[i-1])) continue;
            int j = i+1;
            int k = length-1;
            int sum = -nums[i];
            while (j < k){
                int twoSum = nums[j] + nums[k];
                if(twoSum == sum){
                    List<Integer> three = new ArrayList<Integer>(Arrays.asList(-sum,nums[j],nums[k]));
                    threeSum.add(three);
                    while(j<k && nums[j]==nums[j+1]) j++;
                    while(j<k && nums[k]==nums[k-1]) --k;
                    j++;
                    k--;
                } else if(twoSum < sum){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return threeSum;
    }

    public static void main (String[] args){
        int[] nums = {-1,-1,2};
        System.out.print(threeSum(nums));
    }
}
