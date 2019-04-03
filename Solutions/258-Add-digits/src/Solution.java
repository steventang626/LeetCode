public class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            int result = 0;
            while (num > 0) {
                result += num % 10;
                num = num / 10;
            }
            num = result;
        }
        return num;
    }

    public int addDigits2(int num) {
        return (num == 0) ? 0 : (num - 1) % 9 + 1;
    }

    public int addDigits3(int num) {
        return (num < 10) ? num : addDigits3(addDigits3(num / 10) + addDigits3(num % 10));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addDigits2(38));
    }
}
