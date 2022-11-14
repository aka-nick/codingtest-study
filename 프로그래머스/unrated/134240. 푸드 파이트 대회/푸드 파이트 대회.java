import java.util.*; 

class Solution {
    public String solution(int[] food) {
        
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int numberOfRound = food[i] / 2;
            if (numberOfRound <= 0) {
                continue;
            }
            
            for (int j = 0; j < numberOfRound; j++) {
                sb.append(i);
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        return result.append(sb)
            .append("0")
            .append(sb.reverse())
            .toString();
    }
}