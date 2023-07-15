import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s, String skip, int index) {
        // s.charAt =(+skips[index])=> sb.append(newChar).toString()
        int[] skips = new int[26];
        Arrays.fill(skips, 1);
        IntStream.range(0, skip.length())
            .forEach(idx -> skips[skip.charAt(idx) - 'a'] = 0);
        
        StringBuilder result = new StringBuilder();
        IntStream.range(0, s.length())
            .forEach(idx -> {
                int i = 0;
                char newChar = s.charAt(idx);
                while (i < index) {
                    i++;
                    newChar++;
                    if (26 <= newChar - 'a') newChar = 'a';
                    
                    if (skips[newChar - 'a'] == 0) i--;
                }
                result.append(newChar);
            });
        
        return result.toString();
    }
    
    void println(Object obj) {
        System.out.println(String.valueOf(obj));
    }
}