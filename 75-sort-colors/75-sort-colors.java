class Solution {
    public void sortColors(int[] nums) {
		int left = 0, right = nums.length - 1, i = 0;

		while (i <= right) {
			if (nums[i] == 0) {
				arrswap(nums, i, left);
				left += 1;
				i += 1;
			}
			else if (nums[i] == 2) {
				arrswap(nums, i, right);
				right -= 1;
			}
			else { // nums[i] == 1
				i += 1;
			}
		}
	}
	
	public void arrswap(int[] nums, int s1, int s2) {
		int tmp = nums[s1];
		nums[s1] = nums[s2];
		nums[s2] = tmp;
	}
}