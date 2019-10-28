public class Solution {
    public String getHint(String secret, String guess) {
        int[] digitsSecret = new int[10];
        int[] digitsGuess = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char recentSecret = secret.charAt(i);
            char recentGuess = guess.charAt(i);
            if (recentSecret == recentGuess) {
                bulls++;
            } else {
                digitsSecret[recentSecret - '0']++;
                digitsGuess[recentGuess - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows += Math.min(digitsSecret[i], digitsGuess[i]);
        }
        return bulls + "A" + cows + "B";
    }

    // With less space
    public String getHint2(String secret, String guess) {
        int[] digits = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char recentSecret = secret.charAt(i);
            char recentGuess = guess.charAt(i);
            if (recentSecret == recentGuess) {
                bulls++;
            } else {
                if (digits[recentSecret - '0']++ < 0) {
                    cows++;
                }
                if (digits[recentGuess - '0']-- > 0) {
                    cows++;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
	    String secret = "1807";
	    String guess = "7810";
	    System.out.println(new Solution().getHint2(secret, guess));
    }
}
