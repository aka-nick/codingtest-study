class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n <= 0) return;
		
		int arr1Pointer = m - 1, arr2Pointer = n - 1, swapPointer = nums1.length - 1;
		
		while(arr1Pointer >= 0 && arr2Pointer >= 0) {
			if (nums1[arr1Pointer] <= nums2[arr2Pointer]) {
				nums1[swapPointer] = nums2[arr2Pointer];
				arr2Pointer -= 1;
				swapPointer -= 1;
			}
			else {
				nums1[swapPointer] = nums1[arr1Pointer];
				arr1Pointer -= 1;
				swapPointer -= 1;
			}
		}
		
		while(arr2Pointer >= 0) {
			nums1[swapPointer] = nums2[arr2Pointer];
			swapPointer -= 1;
			arr2Pointer -= 1;
		}
	}
}