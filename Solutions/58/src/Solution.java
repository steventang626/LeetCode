public class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        String[] split = s.split(" ");
        if(split.length == 0) return 0;
        result = split[split.length - 1].length();
        return result;
    }
    public int lengthOfLastWord2(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
    public static void main(String[] args){
        int result = new Solution().lengthOfLastWord2("qq e");
        System.out.println(result);
    }
}
