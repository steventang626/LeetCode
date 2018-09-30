public class Solution {
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        int i = 1;
        while (x/i >= 10) i *= 10;

        while (x > 0){
            int first = x / i;
            int last = x % 10;
            if (first != last) return false;
            x = x % i;
            x = (x-last) / 10;
            i /= 100;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(-12));
        System.out.println(isPalindrome(123321));
        System.out.println(isPalindrome(123));
    }
}
