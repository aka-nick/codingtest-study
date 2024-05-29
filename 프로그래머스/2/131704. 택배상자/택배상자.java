import java.util.*;

class Solution {

    public int solution(int[] order) {
        Stack<Integer> stash = new Stack<>();
        List<Integer> loads = new ArrayList<>();
        int orderIdx = 0;
        
        for (int item = 1; item <= order.length; item++) {
            boolean isLoad = false;
            if (item == order[orderIdx]) {
                loads.add(item);
                orderIdx++;
                isLoad = true;
            }
            while (!stash.isEmpty() && stash.peek() == order[orderIdx]) {
                loads.add(stash.pop());
                orderIdx++;
                isLoad = true;
            }
            if (!isLoad) {
                stash.push(item);
            }
        }
        
        return loads.size();
    }
    
}