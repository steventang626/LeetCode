import java.util.HashMap;

public class Solution {
    public static int romanToInt1(String s) {
        int x = 0 , i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c == 'M') {
                x += 1000;
                i++;
                continue;
            }
            if(c == 'C'){
                if(i+1<s.length()){
                    if(s.charAt(i+1) == 'D'){
                        x += 400;
                        i = i + 2;
                        continue;
                    }
                    if(s.charAt(i+1) == 'M'){
                        x += 900;
                        i = i + 2;
                        continue;
                    }
                }
                x += 100;
                i++;
                continue;
            }
            if(c == 'D') {
                x += 500;
                i++;
                continue;
            }
            if(c == 'X'){
                if(i+1<s.length()){
                    if(s.charAt(i+1) == 'L'){
                        x += 40;
                        i = i + 2;
                        continue;
                    }
                    if(s.charAt(i+1) == 'C'){
                        x += 90;
                        i = i + 2;
                        continue;
                    }
                }
                x += 10;
                i++;
                continue;
            }
            if(c == 'L') {
                x += 50;
                i++;
                continue;
            }
            if(c == 'I'){
                if(i+1<s.length()){
                    if(s.charAt(i+1) == 'V'){
                        x += 4;
                        i = i + 2;
                        continue;
                    }
                    if(s.charAt(i+1) == 'X'){
                        x += 9;
                        i = i + 2;
                        continue;
                    }
                }
                x += 1;
                i++;
                continue;
            }
            if(c == 'V') {
                x += 5;
                i++;
                continue;
            }
        }
        return x;
    }

    public static int romanToInt(String s) {
        int x = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);
        for (int i=0; i<s.length(); i++){
            int n = map.get(s.charAt(i));
            if(i == s.length()-1 || n >= map.get(s.charAt(i+1))){
                x = x + n;
            } else {
                x = x - n;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("DCXXI"));
    }
}
