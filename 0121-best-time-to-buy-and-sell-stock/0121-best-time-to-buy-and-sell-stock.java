class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        
        int left = prices[0];
        int right = -1;
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int now = prices[i];
            
            if (now < left) {
                left = now;
                right = -1;
                continue;
            }
            if (right <= now) {
                right = now;
                result = Math.max(result, right - left);
            }
        }

        return result;
    }
}