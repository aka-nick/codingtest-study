class Solution {
    private boolean vP(String s, boolean neverPassed) {
		for (int i = 0, j = s.length() - 1; i < s.length() / 2; i += 1, j -= 1) {
			char ic = s.charAt(i);
			char jc = s.charAt(j);

			if (ic != jc)
				if (neverPassed)
					return vP(s.substring(i + 1, j + 1), false) || vP(s.substring(i, j), false);
				else
					return false;
		}

		return true;
	}

	public boolean validPalindrome(String s) {
		return vP(s, true);
	}
}