public class Solution {
    public int numDecodings1(String s) {
        // Time Limit Exceeded
        if(s.length() == 1){
            if(s.charAt(0) > '0' && s.charAt(0) <= '9'){
                return 1;
            }else return 0;
        }
        if(s.length() == 2){
            if(s.charAt(0) == '0'){
                return 0;
            }else if(s.charAt(0) == '1'){
                if(s.charAt(1) == '0'){
                    return 1;
                }else return 2;
            }else if(s.charAt(0) == '2'){
                if(s.charAt(1) < '1' || s.charAt(1) > '6'){
                    return 1;
                }else return 2;
            }else if(s.charAt(1) != '0'){
                return 1;
            }else return 0;
        }
        int result = 0;
        if(numDecodings(s.substring(0,1)) == 1){
            result += numDecodings(s.substring(1));
        }
        if(s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) <= '6')){
            result += numDecodings(s.substring(2));
        }
        return result;
    }

    public int numDecodings(String s) {
        int[] result = new int[s.length() + 1];
        result[0] = 1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '0'){
                result[i + 1] += result[i];
            }
            if(i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))){
                result[i + 1] += result[i - 1];
            }
        }
        return result[s.length()];
    }
    public static void main(String[] args){
        int result = new Solution().numDecodings("226");
        System.out.println(result);
    }
}
