public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        if(num2.equals("1")) return num1;
        if(num1.equals("1")) return num2;
        int l1 = num1.length();
        int l2 = num2.length();
        int[] n1 = new int[l1];
        int[] n2 = new int[l2];
        int[][] result_num = new int[l2][l1 + l2];
        int[] result = new int[l1 + l2];

        for(int i = 0; i < l1; i++){
            n1[i] = num1.charAt(l1 - 1 - i) - '0';
            //System.out.print(n1[i]);
        }
        for(int i = 0; i < l2; i++){
            n2[i] = num2.charAt(l2 - 1 - i) - '0';
            //System.out.print(n2[i]);
        }
        //System.out.println();
        for(int i = 0; i<l2; i++){
            int multiplier = n2[i];
            int carry = 0;
            for(int j = 0; j<l1; j++){
                int r = multiplier * n1[j] + carry;
                result_num[i][i+j] = r % 10;
                carry = r / 10;
            }
            result_num[i][i+l1] = carry;
        }
//        for(int i = 0; i<l2; i++){
//            for(int j = 0; j<l1+l2; j++) {
//                System.out.print(result_num[i][j]);
//            }
//            System.out.println();
//        }
        int carry = 0;
        for(int i = 0; i < l1 + l2; i++){
            int sum = carry;
            for(int j = 0; j<l2; j++){
                sum = sum + result_num[j][i];
            }
            result[i] = sum % 10;
            //System.out.print(result[i]);
            carry = sum / 10;
        }
        //System.out.println();

        StringBuilder r = new StringBuilder();
        if(result[l1 + l2 -1] != 0) r.append(result[l1 + l2 -1]);
        for(int i = 2; i <= l1 + l2; i++){
            r = r.append(result[l1 + l2 -i]);
        }
        return r.toString();
    }
    public static void main(String[] args){
        String num1 = "2";
        String num2 = "3";
        String result = new Solution().multiply(num1, num2);
        System.out.println(result);
    }
}
