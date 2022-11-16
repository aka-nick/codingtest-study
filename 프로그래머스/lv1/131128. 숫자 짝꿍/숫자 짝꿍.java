import java.util.*;

class Solution {

    public String solution(String X, String Y) {
        
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        boolean onlyZero = false;
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        
        for (char c : X.toCharArray()) {
            xArr[c - '0']++;
        }
        for (char c : Y.toCharArray()) {
            yArr[c - '0']++;
        }
        
        for (int i = 9; 0 <= i; i--) {
            while (0 < xArr[i] && 0 < yArr[i]) {
                
                if (!found && i == 0) {
                    onlyZero = true;
                }
                
                found = true;
                sb.append(i);
                xArr[i]--;
                yArr[i]--;
            }
        }
        
        return getResult(found, onlyZero, sb);
    }
    
    private String getResult(boolean found, boolean onlyZero, StringBuilder sb) {
        String result;
        
        if (!found) {
            result = "-1";
        }
        else if (onlyZero) {
            result = "0";
        }
        else {
            result = sb.toString();
        }
        
        return result;
    }
    
}