import java.util.ArrayList;

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        int length = s.length();
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        int pos_e = -1;
        int pos_dot = -1;
        for(int i = 0; i < length; i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            }else if (s.charAt(i) == '+') {
                positive.add(i);
                if(positive.size() > 2) return false;
            }else if(s.charAt(i) == '-'){
                negative.add(i);
                if(negative.size() > 2) return false;
            }else if(s.charAt(i) == 'e'){
                if(pos_e == -1) pos_e = i;
                else return false;
            }else if(s.charAt(i) == '.'){
                if(pos_dot == -1) pos_dot = i;
                else return false;
            }else {
                return false;
            }
        }
        for (int i:positive) {
            if(i == length - 1) return false;
            if(i != 0 && i != (pos_e + 1)) return false;
        }
        for (int i:negative) {
            if(i == length - 1) return false;
            if(i != 0 && i != (pos_e + 1)) return false;
        }
        s = s.replace("+","");
        s = s.replace("-","");
        length = s.length();

        for(int i = 0; i < length; i++){
            if(s.charAt(i) == 'e'){
                pos_e = i;
            }else if(s.charAt(i) == '.'){
                pos_dot = i;
            }
        }

        if(pos_e == 0 || pos_e == length - 1) return false;
        if(pos_dot != -1 && pos_e != -1 && (pos_dot > pos_e)) return false;
        if(length == 1 && pos_dot == 0) return false;
        if(pos_dot == 0 && pos_e == 1) return false;

        return true;
    }
    public static void main(String[] args){
        String a = " -.";
        boolean result = new Solution().isNumber(a);
        System.out.println(result);
    }
}

