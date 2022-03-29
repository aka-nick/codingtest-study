import java.util.HashSet;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> numSet = new HashSet<Integer>();
		for (int n : nums) numSet.add(n);
		
        return (nums.length / 2) <= (numSet.size()) ? (nums.length / 2) : (numSet.size());
    }
}