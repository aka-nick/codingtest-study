class Solution {
    public int pivotIndex(int[] nums) {
		int lSum = 0, rSum = 0;
		for (int i = 0; i < nums.length; i += 1) rSum += nums[i];
		
		for (int pIdx = 0; pIdx < nums.length; pIdx += 1) {
			if (pIdx > 0) lSum += nums[pIdx - 1];
			
			if (pIdx < nums.length) rSum -= nums[pIdx];
			
			if (lSum == rSum) return pIdx;
		}
		return -1;
	}
}