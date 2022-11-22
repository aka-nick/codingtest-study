import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        score = Arrays.stream(score)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(i -> i)
            .toArray();
        
        int result = 0;
        for (int i = m - 1; i < score.length; i += m) {
            result += score[i];
        }
        result *= m;
        
        return result;
    }
}