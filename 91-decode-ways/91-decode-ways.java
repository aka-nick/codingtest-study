class Solution {
    
    public int numDecodings(String s) {
		int[] memo = new int[s.length()];
		memo[0] = s.charAt(0) == '0' ? 0 : 1;
		
		for (int i = 1 ; i < s.length(); i += 1) {
			int singleDigit = s.charAt(i) - 48; // '0' is 48
			int doubleDigit = (s.charAt(i - 1) - 48) * 10 + singleDigit;
			
			if (singleDigit != 0) memo[i] = memo[i - 1]; // 1 <= sD <= 9
			if (10 <= doubleDigit && doubleDigit <= 26) 
				memo[i] += i >= 2 ? memo[i - 2] : 1;
		}
		
		return memo[s.length() - 1];
	}
    
}