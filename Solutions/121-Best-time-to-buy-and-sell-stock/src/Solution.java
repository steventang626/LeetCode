public class Solution {
    // Time O(n), Space O(1)
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int length = prices.length;
        int minPrice = Integer.MAX_VALUE;
        if(length <= 1) return 0;
        for(int i = 0; i < length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int result = new Solution().maxProfit(prices);
        System.out.println(result);
    }
}
