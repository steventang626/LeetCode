import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static int lengthOfLongestSubstring1(String s) {
        // 超时
        int longest = 0;
        int length = s.length();
        int end = length;
        for(int i = 0; i < length; i++){
            for (int j = i; j < end; j++){
                char temp = s.charAt(j);
                String subString = s.substring(j+1,end);
                int templength = subString.indexOf(temp);
                if (templength != -1) {
                    end = j + templength +1;
                }
            }
        int len = end - i;
        if (len > longest) longest = len;
        end = length;
        }
        return longest;
    }

    public static int lengthOfLongestSubstring2(String s) {
        // 时间很长
        int longest = 0;
        int length = s.length();
        int end = length;
        int[] list = new int[length];
        for(int i = 0; i < length; i++){
            list[i] = -1;
            if(s.substring(i+1).indexOf(s.charAt(i))!= -1){
                list[i] = i + s.substring(i+1).indexOf(s.charAt(i)) + 1;
            }
            //System.out.print(list[i]);
        }
        for(int i = 0; i < length; i++){
            for (int j = i; j < end; j++){
                if (list[j] != -1) {
                    if (list[j] < end)
                    end = list[j];
                }
            }
            int len = end - i;
            if (len > longest) longest = len;
            end = length;
        }
        return longest;
    }

    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int[] m = new int[256];
        Arrays.fill(m, -1);
        int left = -1;
        for (int i = 0; i < s.length(); i++){
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            longest = Math.max(longest, i-left);
        }
        return longest;
    }


    public static void main(String[] args) {
        int a = lengthOfLongestSubstring("abcabcd");
        System.out.print(a);
        int b = lengthOfLongestSubstring("bbbbbb");
        System.out.print(b);
        int c = lengthOfLongestSubstring("pwwkew");
        System.out.print(c);
        //int c = lengthOfLongestSubstring("pwwkew");
        //System.out.print("abc".substring(0,3));
    }
}
