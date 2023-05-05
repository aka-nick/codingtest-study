import java.util.*;

class Solution {
    static final boolean ALREADY = false;
    static final boolean NOTYET = true;

    public int solution(int n, int m, int[] section) {
        
        boolean[] wall = new boolean[n + 1];
        for (int s : section) {
            wall[s] = NOTYET;
        }
        
        int countOfPainting = 0;
        for (int i = 1; i <= n; i++) {
            if (wall[i] == ALREADY) continue;
            
            countOfPainting++;
            for (int paint = i; paint < i + m && paint < wall.length; paint++) {
                wall[paint] = ALREADY;
            }
        }
        
        return countOfPainting;
    }
}