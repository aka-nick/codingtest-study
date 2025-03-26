import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> minQ = new PriorityQueue<>();
        Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < operations.length; i++) {
            String[] operation = operations[i].split(" ");
            String command = operation[0];
            Integer data = Integer.valueOf(operation[1]);
            
            if ("I".equals(command)) {
                minQ.offer(data);
                maxQ.offer(data);
            }
            else { // "D".eq(command)
                if (data.equals(1)) {
                    Integer max = maxQ.poll();
                    if (max != null) minQ.remove(max);
                }
                else {
                    Integer min = minQ.poll();
                    if (min != null) maxQ.remove(min);
                }
            }
        }
        
        return 0 < minQ.size() 
            ? new int[]{maxQ.poll(), minQ.poll()}
            : new int[]{0, 0};
    }
}