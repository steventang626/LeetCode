public class Solution {
    public static String convert(String s, int numRows) {
        if(numRows <= 1) return s; // 很重要，要记得加上
        String str = "";
        for (int i = 0; i<numRows; i++){
            for(int j = i; j < s.length(); j = j + 2 * numRows -2) {
                str = str.concat(s.substring(j,j+1)); // 比 str+=s.charAt(j) 快
                int space = 2 * numRows - 2 - 2 * i;
                if(i != 0 && i != (numRows-1) && j + space < s.length()) str = str.concat(s.substring(j+space,j+space+1));
            }
        }
        return str;
    }
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 1));
    }
}
