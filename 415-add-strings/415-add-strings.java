class Solution {
    public String addStrings(String num1, String num2) {//602
		
		char[] a = num1.length() < num2.length() ? num1.toCharArray() : num2.toCharArray();
		char[] b = num1.length() < num2.length() ? num2.toCharArray() : num1.toCharArray();
		int r = 0;

		for (int i = b.length - 1; i >= 0; i -= 1) {	
			int bi = Character.getNumericValue(b[i]);
			if (i >= b.length - a.length) {
				int ai = Character.getNumericValue(a[i - (b.length - a.length)]);
				if (bi + ai + r > 9) {
					b[i] = Character.forDigit(((bi + ai + r) % 10), 10);
					r = 1;
				}
				else {
					b[i] = Character.forDigit((bi + ai + r), 10);
					r = 0;
				}
			}
			else {
				if ((bi + r) > 9) {
					b[i]  = Character.forDigit(((bi + r) % 10), 10);
					r = 1;
				}
				else {
					b[i] = Character.forDigit(bi + r, 10);
					r = 0;
				}
			}
		}
		return r == 1 ? r + String.valueOf(b) : String.valueOf(b);
	}
}