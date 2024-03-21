class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        
        int minPrice = prices[0];
        int result = 0;
        for (int price : prices) {
            result = Math.max(result, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return result;
    }
}