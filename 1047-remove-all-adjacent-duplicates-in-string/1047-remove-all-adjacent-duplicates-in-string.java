class Solution {
    
    public String removeDuplicates(String s) {
		char[] chars = s.toCharArray();
		
		char preChar = '*';
		int lastIdx = -1;
		for (int i = 0; i < chars.length; i += 1) {
			
			if (preChar != chars[i]) {
				lastIdx += 1;
				chars[lastIdx] = chars[i];
				preChar = chars[i];
			}
			else {
				lastIdx -= 1;
				preChar = lastIdx > -1 ? chars[lastIdx] : '*';
			}
			
		}

		return new String(chars, 0, lastIdx + 1);
	}
    
}