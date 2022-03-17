class Solution {
    public int pivotIndex(int[] nums) {
		int pIdx = 0;
		
		for (int idx = 0; idx < nums.length; idx += 1) {
			int lSum = 0, rSum = 0;
			for (int lIdx = 0; lIdx < pIdx; lIdx += 1) {
				lSum += nums[lIdx];
			}
			for (int rIdx = pIdx + 1; rIdx < nums.length; rIdx += 1) {
				rSum += nums[rIdx];
			}
			
			if (lSum == rSum) return pIdx;
			pIdx += 1;
		}
		
		return -1;
	}
}