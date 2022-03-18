class Solution {
    public int minSubArrayLen(int target, int[] nums) {
		
		int left = 0, sum = 0, length = -1;
		
		for (int right = 0; right < nums.length; right += 1) {
			
			sum += nums[right];
			
			while (sum >= target) {
				length = length == -1 ? right - left + 1 : Math.min(right - left + 1, length);
			
				sum -= nums[left];
				left += 1;
			}
		}
		
		return Math.max(0, length);
	}
}