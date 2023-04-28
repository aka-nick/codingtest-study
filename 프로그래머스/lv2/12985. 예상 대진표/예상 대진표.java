import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int a, int b) {
        /*
        3,7
        4,8
        5 6
        
        5 7 
        6 8 -> 3 4 
        4 4 -> 

        1 2 3 4 5 6 7 8
        2 4
        1 2
        1 1
        1 3
        0 1
        */
        
        int round = 1;
        while (true) {
            a += a % 2 != 0 ? 1 : 0;
            b += b % 2 != 0 ? 1 : 0;
            
            if (a == b) return round;
            if (1 < a) a /= 2;
            if (1 < b) b /= 2;
            round++;
        }
    }
}