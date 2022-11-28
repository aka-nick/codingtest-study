import java.util.*;
class Solution {
    public long solution(long n) {
        
        long result = -1;
        
        Double sqrt = Math.sqrt(n);
        if (sqrt == sqrt.intValue()) {
            result = (long) Math.pow(sqrt + 1, 2);    
        }

        return result;
    }
}