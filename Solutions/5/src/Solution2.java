public class Solution2 {
    // Manacher's Algorithm
    public static String longestPalindrome(String s) {
        String t = "$#";
        StringBuilder sb = new StringBuilder(t);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        t = sb.toString();
        int[] p = new int[t.length()];
        int mx = 0, id = 0, resLength = 0, resCenter = 0;
        for (int i = 1; i < t.length(); i++) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (i + p[i] < t.length() && i - p[i] >= 0 && t.charAt(i + p[i]) == t.charAt(i - p[i])) p[i]++;
            if (mx < i + p[i]) {
                mx = i + p[i];
                id = i;
            }
            if (resLength < p[i]) {
                resLength = p[i];
                resCenter = i;
            }
        }
        return s.substring((resCenter - resLength) / 2, (resCenter - resLength) / 2 + resLength - 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("iabbai"));
    }
}
