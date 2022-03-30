import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {        
        ArrayList<Integer> zeroToNine = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for (int num : numbers) numList.add(num);
        
        zeroToNine.removeAll(numList);
        
        int answer = 0;
        for (int value : zeroToNine) answer += value;
        
        return answer;
    }
}