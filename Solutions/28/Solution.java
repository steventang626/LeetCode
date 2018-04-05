public class Solution {
    public int strStr(String haystack, String needle) {
        int length_h = haystack.length();
        int length_n = needle.length();
        for(int i = 0; i <= length_h - length_n; i++){
            if(haystack.substring(i,i+length_n).equals(needle)) return i;
        }
        return -1;
    }
    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    public int strStr2(String haystack, String needle) {
        int length_h = haystack.length();
        int length_n = needle.length();
        for(int i = 0; i <= length_h - length_n; i++){
            boolean r = true;
            for(int j = 0; j < length_n; j++) {
                if(haystack.charAt(j+i) != needle.charAt(j)){
                    r = false;
                    break;
                }
            }
            if(r){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int result = new Solution().strStr("hello","ll");
        System.out.println(result);
        int result1 = new Solution().strStr1("hello","ll");
        System.out.println(result1);
        int result2 = new Solution().strStr2("hello","ll");
        System.out.println(result2);
    }
}
