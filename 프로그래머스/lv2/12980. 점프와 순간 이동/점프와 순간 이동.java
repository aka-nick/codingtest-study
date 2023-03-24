import java.util.*;

public class Solution {
    
    public int solution(int n) {

        // 메모아이제이션을 하지 말자 bottom-up -> top-down
        int move = 0;
        while (0 < n) {
            if (n % 2 == 0) {
                n /= 2;
            }
            else {
                n--;
                move++;
            }
        }

        return move;
    }
    
}