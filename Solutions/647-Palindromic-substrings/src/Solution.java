public class Solution {
    // Manacher's Algorithm
    public int palindrome(String s) {
        int lengthOfString = s.length();
        if(lengthOfString == 0) return 0;
        int result = 0;
        String t = "$#";
        StringBuilder sb = new StringBuilder(t);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        t = sb.toString();
        int[] p = new int[t.length()];
        int mx = 0, id = 0;
        for (int i = 1; i < t.length(); i++) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (i + p[i] < t.length() && i - p[i] >= 0 && t.charAt(i + p[i]) == t.charAt(i - p[i])) {
                p[i]++;
            }
            result += Math.ceil(p[i] / 2.0);
            if (mx < i + p[i]) {
                mx = i + p[i];
                id = i;
            }
        }
        return result - lengthOfString - 1;
    }

    public static void main(String[] args) {
        String s = "abc";
        int result = new Solution().palindrome(s);
        System.out.println(result);
    }
}
