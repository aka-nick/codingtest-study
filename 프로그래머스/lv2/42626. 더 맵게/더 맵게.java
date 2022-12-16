import java.util.*;

class Solution {
    public int solution(int[] scoville, int k) {

        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        setupQueue(scoville, pq);

        while (2 <= pq.size()) {

            if (k <= pq.peek()) break;

            result++;

            Integer minFirst = pq.poll();
            Integer minSecond = pq.poll();

            pq.add(getNewFood(minFirst, minSecond));
        }

        if (pq.peek() < k) {
            result = -1;
        }

        return result;
    }

    private void setupQueue(int[] scoville, PriorityQueue<Integer> pq) {
        for (int i : scoville) {
            pq.add(i);
        }
    }

    private int getNewFood(Integer minFirst, Integer minSecond) {
        return minFirst + (minSecond * 2);
    }
}