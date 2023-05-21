import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int manFrom = Integer.parseInt(st.nextToken());
        int manTo = Integer.parseInt(st.nextToken());
        int numberOfAdj = Integer.parseInt(br.readLine());
        boolean[][] adjacent = new boolean[n + 1][n + 1];
        for (int i = 0; i < numberOfAdj; i++) {
            st = new StringTokenizer(br.readLine());
            int adj1 = Integer.parseInt(st.nextToken());
            int adj2 = Integer.parseInt(st.nextToken());
            adjacent[adj1][adj2] = true;
            adjacent[adj2][adj1] = true;
        }
        br.close();

        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        q.add(manFrom);
        visited[manFrom] = true;
        int step = 0;

        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            while (size-- > 0) {
                int nowFrom = q.pollFirst();
                for (int nowTo = 1; nowTo <= n; nowTo++) {
                    if (nowTo == nowFrom) continue;
                    if (visited[nowTo]) continue;
                    if (!adjacent[nowFrom][nowTo]) continue;

                    if (nowTo == manTo) {
                        System.out.println(step);
                        return;
                    }

                    visited[nowTo] = true;
                    q.add(nowTo);
                }
            }
        }

        System.out.println(-1);
    }

}