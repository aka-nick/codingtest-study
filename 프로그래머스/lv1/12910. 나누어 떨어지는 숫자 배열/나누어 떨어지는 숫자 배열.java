import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        int[] result = Arrays.stream(arr)
	            .sorted()
	            .filter(i -> i % divisor == 0)
	            .map(i -> i)
	            .toArray();
        
		return result.length == 0 ? new int[]{-1} : result;
    }
}