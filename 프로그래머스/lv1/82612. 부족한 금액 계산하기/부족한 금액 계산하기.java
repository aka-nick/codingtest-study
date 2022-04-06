class Solution {
   public long solution(int price, int money, int count) {
		long moneyL = Long.valueOf(money);
		
		for (int n = 1; n <= count; n += 1) 			
			moneyL -= n * price;

		return moneyL < 0 ? -moneyL : 0;
	}
}