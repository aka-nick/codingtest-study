import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int start = Integer.parseInt(line[0]);
        int end = Integer.parseInt(line[1]);
        int m = Integer.parseInt(br.readLine());
        boolean[][] adj = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            int i1 = Integer.parseInt(split[0]);
            int i2 = Integer.parseInt(split[1]);
            adj[i1][i2] = true;
            adj[i2][i1] = true;
        }
        br.close();

        boolean[] visited = new boolean[n + 1];
        Deque<Integer> q = new ArrayDeque<>();

        q.addLast(start);
        visited[start] = true;
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            while (size-->0) {
                Integer now = q.removeFirst();
                for (int i = 1; i <= n; i++) {
                    if (!adj[now][i]) continue;
                    if (visited[i]) continue;

                    if (i == end) {
                        System.out.println(count);
                        return;
                    }

                    q.addLast(i);
                    visited[i] = true;
                }
            }
        }

        System.out.println(-1);
    }

}