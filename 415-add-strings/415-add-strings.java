class Solution {
    public String addStrings(String num1, String num2) {
		
		char[] a = num1.length() < num2.length() ? num1.toCharArray() : num2.toCharArray();
		char[] b = num1.length() < num2.length() ? num2.toCharArray() : num1.toCharArray();
		int diff = b.length - a.length;
		int r = 0;

		for (int i = b.length - 1; i >= 0; i -= 1) {	
			if (i >= diff) {
				if ((b[i] - 48) + (a[i - diff] - 48) + r > 9) {
					b[i] = (char) (((b[i] - 48) + (a[i - diff] - 48) + r) % 10 + '0');
					r = 1;
				}
				else {
					b[i] = (char)(b[i] - 48 + a[i - diff] - 48 + r + '0');
					r = 0;
				}
			}
			else {
				if ((b[i] + r - 48 + 0) > 9) {
					b[i]  = (char)((b[i] + r - 48 + 0) % 10 + '0');
					r = 1;
				}
				else {					
					b[i] = (char)(b[i] + r - 48 + '0');
					r = 0;
				}
			}
		}
		return r == 1 ? r + String.valueOf(b) : String.valueOf(b);
	}
}