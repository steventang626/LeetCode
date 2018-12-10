public class Solution {
    public int maxProfit(int[] prices) {
        int buy = -1;
        int result = 0;
        int length = prices.length;
        if(length <= 1) return result;
        if(prices[0] < prices[1]) buy = prices[0];
        for(int i = 1; i < length - 1; i++) {
            if(prices[i] >= prices[i - 1] && prices[i] > prices[i + 1] && buy != -1) {
                result += prices[i] - buy;
                buy = -1;
            } else if(prices[i] <= prices[i - 1] && prices[i] < prices[i + 1] && buy == -1) {
                buy = prices[i];
            }
        }
        if(prices[length - 1] > buy && buy != -1) {
            result += prices[length - 1] - buy;
        }
        return result;
    }

    public int maxProfit2(int[] prices) {
        int result = 0;
        int length = prices.length;
        if(length <= 1) return result;
        for(int i = 0; i < length - 1; i++) {
            if(prices[i] < prices[i + 1]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {0,5,5,6,2,1,1,3};
        int result = new Solution().maxProfit2(prices);
        System.out.println(result);
    }
}
