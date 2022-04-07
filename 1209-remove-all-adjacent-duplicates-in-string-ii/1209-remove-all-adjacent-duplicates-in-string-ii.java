class Solution {
    public String removeDuplicates(String s, int k) {
		char[] chars = s.toCharArray();
		int[][] charCnts = new int[chars.length][2]; // { {charNum, cnt}, ...}
		
		int cursor = 0;
		for (int charIdx = 0; charIdx < chars.length; charIdx++, cursor++) {
			
			int cNum = chars[charIdx];
			if (cursor == 0) 
				charCnts[cursor] = new int[]{cNum, 1};
			else if (charCnts[cursor - 1][0] == cNum)
				charCnts[cursor] = new int[]{cNum, charCnts[cursor - 1][1] + 1};
			else 
				charCnts[cursor] = new int[]{cNum, 1};
			
			if (charCnts[cursor][1] < k) 
				chars[cursor] = (char) charCnts[cursor][0];
			else 
				cursor -= k;
			
		}

		return new String(chars, 0, cursor);
	}
}