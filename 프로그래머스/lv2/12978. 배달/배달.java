import java.util.Arrays;

class Solution {

    private static final int NO_ENTRY = -1;

    public int solution(int n, int[][] road, int k) {
        int[][] adjacent = new int[n + 1][n + 1];
        for (int i = 0; i < adjacent.length; i++) {
            Arrays.fill(adjacent[i], NO_ENTRY);
        }
        for (int[] ints : road) {
            int s = ints[0];
            int e = ints[1];
            int weight = ints[2];
            if (adjacent[s][e] == -1) {
                adjacent[s][e] = weight;
                adjacent[e][s] = weight;
            }
            if (weight < adjacent[s][e]) {
                adjacent[s][e] = weight;
                adjacent[e][s] = weight;
            }
        }

        boolean[] visited = new boolean[n + 1];
        boolean[] success = new boolean[n + 1];
        visited[1] = true;
        success[1] = true;

        dfs(1, 0, 1, k, adjacent, visited, success);

        int result = 0;
        for (boolean s : success) {
            if (s) {
                result += 1;
            }
        }

        return result;
    }

    static int dfs(int node, int sum, int count, int k,
            int[][] adjacent, boolean[] visited, boolean[] success) {
        for (int i = 1; i < adjacent.length; i++) {
            int weight = adjacent[node][i];
            if (!visited[i] &&
                    weight != NO_ENTRY &&
                    0 < weight &&
                    sum + weight <= k) {
                visited[i] = true;
                success[i] = true;
                sum += weight;
                count = dfs(i, sum, count, k, adjacent, visited, success) + 1;
                sum -= weight;
                visited[i] = false;
            }
        }
        return count;
    }

}