class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i += 1) {
        	for (int o = i + 1; o < nums.length - 1; o += 1) {
        		for (int p = o + 1; p < nums.length; p += 1) {
        			if(checkSosu(nums[i] + nums[o] + nums[p])) {
        				answer += 1;
        			}
        			
                }	
            }	
        }
        
        return answer;
    }
	
	private boolean checkSosu(int num) {
		for (int i = 2; i < num; i += 1) {
			if (num % i == 0) return false;
		}
		return true;
	}
}