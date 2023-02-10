import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        boolean[][] adjacent = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjacent[v1][v2] = true;
            adjacent[v2][v1] = true;
        }
        br.close();

        boolean[] visited = new boolean[n + 1];
        int result = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                result++;
                q.addLast(i);
                visited[i] = true;
            }

            while (!q.isEmpty()) {
                int now = q.pollFirst();
                for (int j = 1; j <= n; j++) {
                    if (adjacent[now][j] && !visited[j]) {
                        q.addLast(j);
                        visited[j] = true;
                    }
                }
            }
        }

        System.out.println(result);
    }
    
}