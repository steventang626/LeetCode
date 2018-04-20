public class Solution {
    public static boolean isMatch(String s, String p) {
        // 超时
        if(s.length() == 0 && p.length() == 0) return true;
        if(s.length() >= 1 && p.length() == 0) return false;
        if(p.length() == 1) {
            if(p.charAt(0) == '*') return true;
            else if(s.length() == 1){
                if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') return true;
                else return false;
            } else return false;
        }

        int length_p = p.length();
        int i = 1;
        while(i<length_p){
            if(p.charAt(i) == '*' && p.charAt(i-1) == '*'){
                p = p.substring(0,i) + p.substring(i+1);
                length_p--;
            }else {
                i++;
            }
        }

        if((p.charAt(0) != '?') && (p.charAt(0) != '*')){
            if (s.isEmpty()) return false;
            else if(s.charAt(0) == p.charAt(0)){
                return isMatch(s.substring(1), p.substring(1));
            } else return false;
        }
        if(p.charAt(0) == '?'){
            if (s.isEmpty()) return false;
            else return isMatch(s.substring(1), p.substring(1));
        }
        if(p.charAt(0) == '*'){
            while (s.length() > 0){
                if (isMatch(s, p.substring(1))) return true;
                s = s.substring(1);
            }
        }
        return isMatch(s, p.substring(1));
    }

    public static boolean isMatch2(String s, String p) {
        int length_p = p.length();
        int length_s = s.length();
        int scur = 0,sstar = -1,pcur = 0,pstar = -1;

        while(scur<length_s){
            if((pcur < length_p) && ((s.charAt(scur) == p.charAt(pcur)) || (p.charAt(pcur) == '?'))){
                pcur++;
                scur++;
            } else if((pcur < length_p) && (p.charAt(pcur) == '*')){
                pstar = pcur;
                pcur++;
                sstar = scur;
            } else if(pstar != -1 && pstar < length_p){
                pcur = pstar + 1;
                sstar++;
                scur = sstar;
            } else return false;
        }
        while(pcur < length_p && p.charAt(pcur) == '*') pcur++;
        if(pcur < length_p) return false;
        else return true;
    }

    public static void main(String[] args){
        System.out.println(isMatch2("ac", "a*******b"));
    }
}
