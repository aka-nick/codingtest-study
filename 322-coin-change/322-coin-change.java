class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] mem = new int[amount + 1];
		mem[0] = 0;
		for (int i = 1; i < mem.length; i += 1) mem[i] = -1;
		
		for (int n = 1; n <= amount; n += 1) {
			int fn = -1;
			
			for (int c : coins) 
				if (n - c >= 0 && mem[n - c] != -1)
					if (fn == -1) 
						fn = mem[n - c];
					else 
						fn = Math.min(fn, mem[n - c]);
			
			if (fn == -1) 
				mem[n] = -1;
			else 
				mem[n] = fn + 1;
		}
		
		return mem[amount];
        
    }
}