public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "");
        S = S.toUpperCase();
        int length = S.length();
        int first = length % K;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < first; i++) {
            sb.append(S.charAt(i));
        }
        for (int i = first; i < length; i = i + K) {
            sb.append("-");
            for (int j = 0; j < K; j++) {
                sb.append(S.charAt(i + j));
            }
        }
        String result = sb.toString();
        if (result.length() > 0 && result.charAt(0) == '-') {
            result = result.substring(1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().licenseKeyFormatting("2-5g-3-J", 2));
    }
}
