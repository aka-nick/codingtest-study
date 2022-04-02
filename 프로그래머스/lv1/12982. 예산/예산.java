import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] d, int budget) {
        List<Integer> dlist = new ArrayList<Integer>();
        for (int item : d) dlist.add(item);
        dlist.sort(null);
        
        int answer = 0;
        for (int ditem : dlist) {
        	budget -= ditem;
        	
        	if (budget < 0) break;
        	
        	answer += 1;
        }
        
        return answer;
    }
}