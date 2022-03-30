class Solution {
    public int solution(int n) {
		StringBuilder tNumbers = new StringBuilder();

		while(n > 0) {
			tNumbers.append(n % 3);
			n /= 3;
		}
		
		return Integer.parseInt(tNumbers.toString(), 3);
	}
}