import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if(n == 0) return result;
        result.add(1);
        if(n == 1) return result;
        int num = 1;
        for(int i = 2; i <= n; i++){
            num = 2 * num;
            for(int j = num - 1; j >= 0; j--){
                result.add(result.get(j)+num);
            }
        }
        return result;
    }
    public static void main(String[] args){
        List<Integer> result = new Solution().grayCode(3);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i)+" ");
        }
    }
}
