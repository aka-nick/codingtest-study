class Solution {
    static int N;
	public String[] solution(int n, int[] arr1, int[] arr2) {
		N = n;
		
//        String[] wall1 = intToWall(arr1);
//        String[] wall2 = intToWall(arr2);
//        return combineWall(wall1, wall2);

        return intToWall2(arr1, arr2);
    }
	
	private static String[] intToWall2(int[] arr1, int[] arr2) {
		String[] wallArr = new String[N];
		for (int i = 0; i < N; i += 1) {
			wallArr[i] = String.format("%" + N + "s", Integer.toBinaryString(arr1[i] | arr2[i]))
					.replace("1", "#")
					.replace("0", " ");
		}
		return wallArr;
	}
}