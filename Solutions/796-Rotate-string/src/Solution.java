public class Solution {
    // Time O(n^2), Space O(n)
    public boolean rotateString(String A, String B) {
        String AA = A + A;
        int lengthOfA = A.length();
        if(lengthOfA != B.length()) return false;
        if(lengthOfA == 0) return true;
        for(int i = 0; i < lengthOfA; i++) {
            String rotate = AA.substring(i, i + lengthOfA);
            if(rotate.equals(B)) return true;
        }
        return false;
    }

    // Time O(n^2), Space O(n)
    public boolean rotateString2(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rotateString2("abcde", "abced"));
    }
}
