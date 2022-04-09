class Solution {
    public int climbStairs(int n) {
		
		if (n == 1) return 1;
		else if (n == 2) return 2;
		
		int dn, d1 = 1, d2 = 2;
		
		for (int i = 3; i <= n; i += 1) {
			dn = d1 + d2;
			d1 = d2;
			d2 = dn;
		}
		
		return d2;
		
	}
}