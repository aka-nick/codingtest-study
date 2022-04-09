class Solution {
    public int climbStairs(int n) {
		
		if (n == 1) return 1;
		else if (n == 2) return 2;
		
		int[] dArr = new int[n + 1];
		dArr[1] = 1;
		dArr[2] = 2;
		
		for (int i = 3; i <= n; i += 1) 
			dArr[i] = dArr[i - 2] + dArr[i - 1];
		
		return dArr[n];
		
	}
}