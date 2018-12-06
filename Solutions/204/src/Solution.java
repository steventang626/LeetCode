public class Solution {
    public boolean isPrime(int n) {
        for(int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public int countPrimes(int n) {
        if(n <= 2) return 0;
        int result = 0;
        for(int i = 2; i < n; i++) {
            if (isPrime(i)) result++;
        }
        return result;
    }

    public int countPrimes2(int n) {
        if(n <= 2) return 0;
        int result = 0;
        int sqrt = (int) Math.sqrt(n);
        boolean isNotPrime[] = new boolean[n];
        for(int i = 2; i <= sqrt; i++) {
            if (!isNotPrime[i]) {
                // 这里用 i * i 而不需要从 i * 2开始
                for(int j = i * i; j < n; j = j + i) {
                    isNotPrime[j] = true;
                }
            }
        }
        for(int i = 2; i < n; i++) {
            if (!isNotPrime[i]) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes2(10));
    }

}
