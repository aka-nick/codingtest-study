class Solution {
    public void rotate(int[][] matrix) {
		
		int n = matrix.length;
		int swapI = n / 2;
		int swapJ = swapI + n % 2;
		
		for (int i = 0; i < swapI; i += 1) {
			for (int j = 0; j < swapJ; j += 1) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = tmp;
			}
		}
		
	}
}