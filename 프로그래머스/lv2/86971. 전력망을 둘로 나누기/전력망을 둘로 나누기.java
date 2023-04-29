import java.util.*;

class Solution {

    private boolean[][] adjacent;

    public int solution(int n, int[][] wires) {

        adjacent = new boolean[n + 1][n + 1];
        wiring(wires);

        int diff = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            cutting(wire);

            int diffOfNodes = getDiffOfNodes();
            if (diffOfNodes < diff) diff = diffOfNodes;

            rewiring(wire);
        }

        return diff;
    }

    private void wiring(int[][] wires) {
        for (int[] wire : wires) {
            adjacent[wire[0]][wire[1]] = true;
            adjacent[wire[1]][wire[0]] = true;
        }
    }
    private void cutting(int[] ints) {
        adjacent[ints[0]][ints[1]] = false;
        adjacent[ints[1]][ints[0]] = false;
    }

    private void rewiring(int[] ints) {
        adjacent[ints[0]][ints[1]] = true;
        adjacent[ints[1]][ints[0]] = true;
    }
    private int getDiffOfNodes() {
        // adjacent 기반으로 탐색을 진행
        int countOfTotalNode = adjacent.length - 1;
        int countOfSearchNode = 0;

        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[countOfTotalNode + 1];
        q.addLast(1);
        visited[1] = true;
        countOfSearchNode++;

        while (!q.isEmpty()) {
            int now = q.pollFirst();
            boolean[] linkNodes = adjacent[now];

            for (int i = 1; i < linkNodes.length; i++) {
                if (!linkNodes[i]) continue;

                if (visited[i]) continue;

                visited[i] = true;
                q.addLast(i);
                countOfSearchNode++;
            }
        }

        return Math.abs(countOfSearchNode - (countOfTotalNode - countOfSearchNode));
    }

}