public class Solution {
    public String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length());
        int[] num_a = new int[length + 1];
        int[] num_b = new int[length + 1];
        int[] num_result = new int[length + 1];
        for(int i = 0; i < a.length(); i++){
            num_a[length + 1 - a.length() + i] = a.charAt(i) - '0';
        }
        for(int i = 0; i < b.length(); i++){
            num_b[length + 1 - b.length() + i] = b.charAt(i) - '0';
        }
        int add = 0;
        for(int i = length; i >= 0; i--){
            if(num_a[i] + num_b[i] + add < 2){
                num_result[i] = num_a[i] + num_b[i] + add;
                add = 0;
            }else{
                num_result[i] = num_a[i] + num_b[i] + add - 2;
                add = 1;
            }
        }
        String result = "";
        if(num_result[0] == 1) result = result + "1";
        for(int i = 1; i < num_result.length; i++){
            result = result + num_result[i];
        }
        return result;
    }
    public static void main(String[] args){
        String a = "1010";
        String b = "1011";
        String r = new Solution().addBinary(a,b);
        System.out.print(r);
    }
}
