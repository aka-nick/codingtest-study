class Solution {
    public void moveZeroes(int[] nums) {
		int zIdx = 0;
		
		for (int idx = 0; idx < nums.length; idx += 1) {
			if (nums[idx] != 0) {
				swap(nums, zIdx, idx);
				zIdx += 1;
			}
		}
		
		for (; zIdx < nums.length; zIdx += 1) {
			nums[zIdx] = 0;
		}	
	}
	
	public void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}
}