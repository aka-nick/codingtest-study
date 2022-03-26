import java.util.Arrays;

class Solution {
    
    public int lengthOfLongestSubstring(String s) {

		int maxLen = 0, left = 0, right;
		int[] charArr = new int[128];
		Arrays.fill(charArr, -1);

		for (right = 0; right < s.length(); right += 1) {
			char nowChar = s.charAt(right);
			
			if (charArr[nowChar] != -1 && charArr[nowChar] >= left) {
				left = charArr[nowChar] + 1;
				charArr[nowChar] = right;
			} else {
				charArr[nowChar] = right;
				maxLen = maxLen < right - left + 1 ? right - left + 1 : maxLen;
			}
		}

		return maxLen;
	}
    
}