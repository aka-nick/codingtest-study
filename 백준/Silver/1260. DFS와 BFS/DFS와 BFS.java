import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private static boolean[] visited;
    private static boolean[][] graph;
    private static int n;
    private static int m;
    private static int v;
    private static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        v = Integer.parseInt(split[2]);
        graph = new boolean[n + 1][n + 1];
        while (m-->0) {
            String[] line = br.readLine().split(" ");
            graph[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = true;
            graph[Integer.parseInt(line[1])][Integer.parseInt(line[0])] = true;
        }
        br.close();

        result = new StringBuilder();

        visited = new boolean[n + 1];
        visited[v] = true;
        result.append(v).append(" ");
        dfs(v);

        result.append(System.lineSeparator());

        visited = new boolean[n + 1];
        visited[v] = true;
        result.append(v).append(" ");
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(v);
        while (!q.isEmpty()) {
            Integer now = q.removeFirst();
            for (int i = 1; i <= n; i++) {
                if (graph[now][i] && !visited[i]) {
                    result.append(i).append(" ");
                    visited[i] = true;
                    q.addLast(i);
                }
            }
        }

        System.out.println(result);
    }

    static void dfs(int v) {
        for (int i = 1; i <= n; i++) {
            if (graph[v][i] && !visited[i]) {
                result.append(i).append(" ");
                visited[i] = true;
                dfs(i);
            }
        }
    }

}