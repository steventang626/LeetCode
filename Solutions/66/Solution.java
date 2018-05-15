public class Solution {
    public int[] plusOne1(int[] digits) {
        // 只适合int范围内
        int length = digits.length;
        int num = digits[0];
        for(int i = 1; i <= length - 1; i++){
            num = num * 10 + digits[i];
        }
        num++;
        int new_length = (int) Math.log10(num)+1;
        int[] result = new int[new_length];
        for(int i = 0; i < new_length; i++){
            result[new_length - i - 1] = num % 10;
            num = num / 10;
        }
        //System.out.println(num + " " + new_length);
        return result;
    }
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        Boolean allNine = true;
        for(int i = 0; i < length; i++){
            if(digits[length - 1 - i] != 9){
                allNine = false;
                break;
            }
        }
        if(allNine){
            int[] result = new int[length + 1];
            result[0] = 1;
            return result;
        }
        for(int i = 0; i < length; i++){
            if(digits[length - 1 - i] != 9){
                digits[length - 1 - i]++;
                return digits;
            }else{
                digits[length - 1 - i] = 0;
            }
        }
        return digits;
    }
    public static void main(String[] args){
        int[] a = {9,9,9,9,9};
        int[] result = new Solution().plusOne(a);
        //System.out.println(result.length);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
