import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static Set<Integer>[] adj;
    static boolean[] visited;
    static Integer[] parents;
    static Stack<Integer> searchStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adj = new TreeSet[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new TreeSet();
        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        visited = new boolean[n + 1];
        parents = new Integer[n + 1];

        dfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < parents.length; i++) {
            sb.append(parents[i]).append(System.lineSeparator());
        }

        System.out.println(sb.toString());

    }

    private static void dfs() {
        searchStack.push(1);
        visited[1] = true;

        while (!searchStack.isEmpty()) {
            Integer nowVertex = searchStack.pop();

            for (Integer nextVertex : adj[nowVertex]) {
                if (!visited[nextVertex]) {
                    searchStack.push(nextVertex);
                    visited[nextVertex] = true;
                    parents[nextVertex] = nowVertex; // 부모 정점 저장
                }
            }
        }
    }

}
