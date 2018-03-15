public class Solution {
    public static int myAtoi(String str) {
//        if(str.equals("")){
//            return 0;
//        }
        if(str.isEmpty()) return 0;
        long re = 0;
        while (!str.equals("") && str.charAt(0) == ' '){
            str = str.substring(1);
        }
        if(str.isEmpty()) return 0;
        Boolean isNegative = false;
        if (str.charAt(0) == '-' || str.charAt(0) == '+'){
            if(str.charAt(0) == '-') isNegative = true;
            else isNegative = false;
            str = str.substring(1);
        }
        for(int i = 0; i <str.length();i++) {
            if(str.charAt(i)<'0' || str.charAt(i)>'9'){
                break;
            }
            re = re * 10 + (str.charAt(i) - '0');
            if(re > 2147483647 && isNegative == false){
                return 2147483647;
            }
            if(-re < -2147483648 && isNegative == true){
                return -2147483648;
            }
        }
        if (isNegative) {
            re = -re;
        }
        int ret = (int) re;
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("1223a"));
        System.out.println(myAtoi("-1223"));
        System.out.println(myAtoi("   "));
        System.out.println(myAtoi("-+1"));
        //System.out.println(Integer.parseInt("1223"));
    }
}
