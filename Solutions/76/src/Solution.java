import javafx.util.Pair;

import java.util.ArrayList;

public class Solution {
    public String minWindow(String s, String t) {
        int length_s = s.length();
        int length_t = t.length();
        if(length_s < length_t || length_s == 0) return "";
        int[] ascii = new int[128];
        for(int i = 0; i < length_t; i++){
            ascii[t.charAt(i)]++;
            //System.out.println(ascii[t.charAt(i)]);
        }
        ArrayList<Integer> tInS = new ArrayList<>();
        for(int i = 0; i < length_s; i++){
            if(ascii[s.charAt(i)] > 0){
                tInS.add(i);
            }
        }
        if(tInS.size() < length_t) return "";
        int[] result = new int[2];
        result[0] = 0;
        result[1] = length_s;

        for(int i = 0; i <= tInS.size() - length_t; i++){
            int[] ascii2 = new int[128];
            int total = 0;
            ascii2[s.charAt(tInS.get(i))]++;
            total++;
            if(total == length_t){
                result[1] = tInS.get(i);
                result[0] = tInS.get(i);
                break;
            }
            for(int j = i + 1; j < tInS.size(); j++){
                if(ascii2[s.charAt(tInS.get(j))] < ascii[s.charAt(tInS.get(j))]){
                    ascii2[s.charAt(tInS.get(j))]++;
                    total++;
                }
                if(total == length_t){
                    if(tInS.get(j) - tInS.get(i) <= result[1] - result[0]){
                        result[1] = tInS.get(j);
                        result[0] = tInS.get(i);
                    }
                    break;
                }
            }
        }
        if(result[1] - result[0] == length_s) return "";
        else return s.substring(result[0],result[1]+1);
    }

    public String minWindow1(String s, String t) {
        int length_s = s.length();
        int length_t = t.length();
        if(length_s < length_t || length_s == 0) return "";
        int[] ascii = new int[128];
        for(int i = 0; i < length_t; i++){
            ascii[t.charAt(i)]++;
            //System.out.println(ascii[t.charAt(i)]);
        }
        ArrayList<Integer> tInS = new ArrayList<>();
        for(int i = 0; i < length_s; i++){
            if(ascii[s.charAt(i)] > 0){
                tInS.add(i);
            }
        }
        if(tInS.size() < length_t) return "";
        int[] result = new int[2];
        result[0] = 0;
        result[1] = length_s;

        int left = 0;
        int right = 0;
        int[] ascii2 = new int[128];
        int total = 0;
        for(right = 0; right < tInS.size(); right++){
            ascii2[s.charAt(tInS.get(right))]++;
            if(ascii2[s.charAt(tInS.get(right))] <= ascii[s.charAt(tInS.get(right))]){
                total++;
            }
            while(total == length_t){
                if(tInS.get(right) - tInS.get(left) < result[1] - result[0]){
                    result[1] = tInS.get(right);
                    result[0] = tInS.get(left);
                }
                ascii2[s.charAt(tInS.get(left))]--;
                if(ascii2[s.charAt(tInS.get(left))] < ascii[s.charAt(tInS.get(left))]){
                    total--;
                }
                left++;
            }
        }
        if(result[1] - result[0] == length_s) return "";
        else return s.substring(result[0],result[1]+1);
    }

    public static void main(String[] args){
        String result = new Solution().minWindow1("aaa","a");
        System.out.print(result);
    }
}
