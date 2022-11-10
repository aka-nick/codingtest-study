import java.util.*;

class Solution {
    public String solution(String s, int n) {
        
        StringBuilder result = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            
            if ('a' <= c && c <= 'z') {
                int cint = c + n;
                if ('z' < cint) {
                    cint = 'a' + (cint - 'z' - 1);
                }
                result.append((char) cint);
            }
            else if ('A' <= c && c <= 'Z') {
                int cint = c + n;
                if ('Z' < cint) {
                    cint = 'A' + (cint - 'Z' - 1);
                }
                result.append((char) cint);
            }
            else {
                result.append(c);    
            }
            
        }
        
        return result.toString();
    }
}