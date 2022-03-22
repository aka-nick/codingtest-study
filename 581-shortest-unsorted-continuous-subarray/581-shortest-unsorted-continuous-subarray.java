class Solution {
    public int findUnsortedSubarray(int[] nums) {
		
		if (nums.length <= 1) return 0;
		
		boolean isOrdered = true;
		int left = 0, right = nums.length - 1;
		for (int i = 0; i < nums.length - 1; i += 1) {
			if (nums[i] > nums[i + 1]) {
				left = i;
				isOrdered = false;
				break;
			}
		}
		if (isOrdered) return 0;
		for (int i = nums.length - 1; i > left; i -= 1) {
			if (nums[i] < nums[i - 1]) {
				right = i;
				break;
			}
		}
		
		
		int min = Integer.MAX_VALUE, max = -min;
		for (int i = left; i <= right; i += 1) {
			min = nums[i] < min ? nums[i] : min;
			max = nums[i] > max ? nums[i] : max;
		}
		
		for (int i = 0; i < nums.length; i += 1) {
			if (nums[i] > min) {
				left = i;
				break;
			}
		}
		for (int i = nums.length - 1; i >= 0; i -= 1) {
			if (nums[i] < max) {
				right = i;
				break;
			}
		}
		
		return right - left + 1;
    }
}