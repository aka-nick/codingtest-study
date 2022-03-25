class Solution {
    private char getChar(String s, int idx) {
		// a:97 ~ z:122, A:65 ~ Z:90 | ' ':32, ':':58, ',':44 | 0:48 ~ 9:57
		int charNum = s.charAt(idx) + 0;
		if (48 <= charNum && charNum <= 57 || 97 <= charNum && charNum <= 122) 
			return (char) charNum;
		else if (65 <= charNum && charNum <= 90)
			return (char) (charNum + 32);
		return (char) Character.MIN_VALUE; // 0 
		
	}
	
	public boolean isPalindrome(String s) {
		int j = s.length() - 1;
		
		for (int i = 0; i < s.length() && j >= 0; i += 1) {
			char ic = getChar(s, i);
			char jc = getChar(s, j);
			
			if (i == j) return ic == jc;
			else if (ic == Character.MIN_VALUE) continue;
			
			while (jc == Character.MIN_VALUE) {
				j -= 1;
				jc = getChar(s, j);
			}
			
			if (ic != jc) return false;
			
			j -= 1;
		}
		
		return true;
	}
}