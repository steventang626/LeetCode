import java.net.Inet4Address;

public class Solution {
    public static int myAtoi(String str) {
        if(str.isEmpty()) return 0;
        long result = 0;
        str = str.trim();
        if(str.isEmpty()) return 0;
        boolean isNegative = false;
        if (str.charAt(0) == '-' || str.charAt(0) == '+'){
            if(str.charAt(0) == '-') isNegative = true;
            str = str.substring(1);
        }
        for(int i = 0; i <str.length();i++) {
            if(str.charAt(i)<'0' || str.charAt(i)>'9'){
                break;
            }
            result = result * 10 + (str.charAt(i) - '0');
            if(result > Integer.MAX_VALUE && !isNegative){
                return Integer.MAX_VALUE;
            }
            if(-result < Integer.MIN_VALUE && isNegative){
                return Integer.MIN_VALUE;
            }
        }
        if (isNegative) {
            result = -result;
        }
        return (int) result;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("1223a"));
        System.out.println(myAtoi("  -1223"));
        System.out.println(myAtoi("   "));
        System.out.println(myAtoi("-+1"));
        //System.out.println(Integer.parseInt("1223"));
    }
}
