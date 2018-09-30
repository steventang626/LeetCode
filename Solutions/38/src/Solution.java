public class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }else {
            return countNext(countAndSay(n-1));
        }
    }
    public String countNext(String str) {
        int length = str.length();
        int i = 0;
        StringBuilder result = new StringBuilder();
        while(i<length){
            int count = 0;
            char now = str.charAt(i);
            int j = i+1;
            while(j<length){
                if(str.charAt(j) == now){
                    j++;
                }else{
                    break;
                }
            }
            count = j - i;
            result.append(count);
            result.append(now);
            i = j;
        }
        return result.toString();
    }

    public static void main(String[] args){
        String result = new Solution().countAndSay(4);
        System.out.println(result);
    }
}
