import java.util.*;

class Solution {
    public int solution(String word) {
        
        int loop = 4;
        int v = 1;
        int[] weights = new int[5];
        weights[4] = 1;
        while (loop-->0) {
            weights[loop] = v * 5 + 1;
            v = weights[loop];
        }
        
        int result = word.length();
        String org = "AEIOU";
        for (int i = 0; i < word.length(); i++) {
            int cIdx = org.indexOf(word.charAt(i));
            result += weights[i] * cIdx;
        }
        
        return result;
    }
}