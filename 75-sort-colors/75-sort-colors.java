class Solution {
    public void sortColors(int[] nums) {
		int left = 0, right = nums.length - 1, i = 0;

		while (i <= right) {
			int tmp = 0;
			
			if (nums[i] == 0) {
				tmp = nums[i];
				nums[i] = nums[left];
				nums[left] = tmp;
				
				left += 1;
				i += 1;
			}
			else if (nums[i] == 2) {
				tmp = nums[i];
				nums[i] = nums[right];
				nums[right] = tmp;
				
				right -= 1;
			}
			else { // nums[i] == 1
				i += 1;
			}
		}
	}
}