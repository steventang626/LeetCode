public class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        int aToA = 'a' - 'A';
        for (int i = 0; i < str.length(); i++) {
            char recent = str.charAt(i);
            if (recent >= 'A' && recent <= 'Z') {
                sb.append((char) (recent + aToA));
            } else {
                sb.append(recent);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "About";
        System.out.println(new Solution().toLowerCase(str));
    }
}
