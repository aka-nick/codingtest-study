import java.util.*;

class Solution {

    public int solution(int[] order) {
        Stack<Integer> stash = new Stack<>();
        int loadCount = 0;
        int orderIdx = 0;
        
        for (int item = 1; item <= order.length; item++) {
            boolean isLoad = false;
            if (item == order[orderIdx]) {
                loadCount++;
                orderIdx++;
                isLoad = true;
            }
            while (!stash.isEmpty() && stash.peek() == order[orderIdx]) {
                stash.pop();
                loadCount++;
                orderIdx++;
                isLoad = true;
            }
            if (!isLoad) {
                stash.push(item);
            }
        }
        
        return loadCount;
    }
    
}