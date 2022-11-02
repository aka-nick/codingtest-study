import java.util.*;

class Solution {
    public long[] solution(int x, int n) {

        long[] result = new long[n];
        
        if (x == 0) return result;
        
        int idx = 0;
        long newX = Long.valueOf(x);
        for (long i = newX; Math.abs(i) <= Math.abs(newX * n); i += newX) {
            result[idx++] = i;
        }
        
        return result;
    }
}