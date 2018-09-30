public class Solution {
    public static boolean isMatch(String s, String p) {
        if(s.length() == 0 && p.length() == 0) return true;
        if((s.length() >= 1 && p.length() == 0) || (s.length() != 1 && p.length() == 1)) return false;
        if(s.length() == 1 && p.length() == 1) {
            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') return true;
            else return false;
        }
        //判断第二位是否是"*"是关键
        if (p.charAt(1) != '*') {
            if (s.isEmpty()) return false;
            if((s.charAt(0) == p.charAt(0)) || p.charAt(0) == '.')
                return isMatch(s.substring(1), p.substring(1));
            else
                return false;
        }
        while (s.length() > 0 && ((s.charAt(0) == p.charAt(0)) || p.charAt(0) == '.') ){
            if (isMatch(s, p.substring(2))) return true;
            s = s.substring(1);
        }
        return isMatch(s, p.substring(2));
    }
    public static void main(String[] args){
        System.out.println(isMatch("ab", ".*c"));
    }
}
