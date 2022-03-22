import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
		
		Arrays.sort(intervals, (x,y) -> x[0] - y[0]);
		
		ArrayList<int[]> tmp = new ArrayList<int[]>();
		
		int start = intervals[0][0], end = intervals[0][1];
		for (int i = 1; i < intervals.length; i += 1) {
			if (end < intervals[i][0]) {
				tmp.add(new int[]{start, end});				
				start = intervals[i][0];
			}
			end = end < intervals[i][1] ? intervals[i][1] : end;
		}
		tmp.add(new int[]{start, end});
		
		return tmp.toArray(new int[tmp.size()][]);
    }
}