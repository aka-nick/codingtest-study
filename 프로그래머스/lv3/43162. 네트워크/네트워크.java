import java.util.*;

class Solution {

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;

        for (int startCom = 0; startCom < n; startCom++) {
            if (visited[startCom]) continue;

            result++;
            stack.addLast(startCom);
            visited[startCom] = true;

            while (!stack.isEmpty()) {
                int nowCom = stack.pollLast();
                for (int nextCom = 0; nextCom < n; nextCom++) {
                    if (startCom == nextCom) continue;
                    if (visited[nextCom]) continue;
                    if (computers[nowCom][nextCom] == 0) continue;

                    stack.addLast(nextCom);
                    visited[nextCom] = true;
                }
            }
        }

        return result;
    }

}