import java.util.*;

class Solution {

    String[][] tickets;
    List<String> paths;
    boolean[] visited;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        paths = new LinkedList<>();
        visited = new boolean[tickets.length];

        dfs(0, "ICN", new StringBuilder("ICN"));

        paths.sort(String::compareTo);
        return paths.get(0).split(",");
    }

    void dfs(int depth, String from, StringBuilder path) {
        if (depth == tickets.length) {
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) return;
            }
            paths.add(path.toString());
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!from.equals(tickets[i][0])) continue;
            if (visited[i]) continue;

            visited[i] = true;
            dfs(depth + 1, tickets[i][1], new StringBuilder(path).append(',').append(tickets[i][1]));
            visited[i] = false;
        }
    }

}