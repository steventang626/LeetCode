public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right) {
            char charLeft = s.charAt(left);
            char charRight = s.charAt(right);
            if (!((charLeft >= '0' && charLeft <= '9') || (charLeft >= 'a' && charLeft <= 'z'))) {
                left++;
                continue;
            }
            if (!((charRight >= '0' && charRight <= '9') || (charRight >= 'a' && charRight <= 'z'))) {
                right--;
                continue;
            }
            if (charLeft == charRight) {
                left++;
                right--;
            } else {
                break;
            }
        }
        return (left >= right);
    }
    public static void main(String[] args) {
        String s = "aa";
        System.out.println(new Solution().isPalindrome(s));
    }
}

