public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String str_one = strs[0];
        int n = strs.length;
        int i = 1;
        for (i = 1; i <= str_one.length(); i++){
            String pre = str_one.substring(0,i);
            boolean isPre = true;
            for(int j = 1; j < n; j++){
                if(strs[j].indexOf(pre) != 0){
                    isPre = false;
                    break;
                }
            }
            if(!isPre) break;
        }
        String commomPrefix = str_one.substring(0,i-1);
        return commomPrefix;
    }
    public static void main(String[] args){
        String[] str = {"c","acc","ccc"};
        System.out.println(longestCommonPrefix(str));
    }
}
