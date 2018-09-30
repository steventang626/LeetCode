import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        for(int first = 1; first <= 3; first++){
            for(int second = 1; second <= 3; second++){
                for(int third = 1; third <= 3; third++){
                    for(int fourth = 1; fourth <= 3; fourth++){
                        if(first + second + third + fourth == s.length()){
                            int a = Integer.valueOf(s.substring(0, first));
                            int b = Integer.valueOf(s.substring(first, first + second));
                            int c = Integer.valueOf(s.substring(first + second, first + second + third));
                            int d = Integer.valueOf(s.substring(first + second + third, s.length()));
                            if( a < 256 && b < 256 && c < 256 && d < 256){
                                String result = String.valueOf(a) + "." + String.valueOf(b) + "." +
                                        String.valueOf(c) + "." + String.valueOf(d);
                                if(result.length() == s.length() + 3){
                                    results.add(result);
                                }
                            }
                        }
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args){
        String s = "010010";
        List<String> results = new Solution().restoreIpAddresses(s);
        System.out.println(results);
    }
}
