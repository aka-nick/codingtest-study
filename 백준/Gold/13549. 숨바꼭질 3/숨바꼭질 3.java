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
        int k = Integer.parseInt(st.nextToken());
        br.close();

        int[] times = new int[100001];
        boolean[] visited = new boolean[100001];

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(n);

        while (!q.isEmpty()) {
            int now = q.pollFirst();

            if (now == k) {
                System.out.println(times[now]);
                return;
            }

            if (!isOut(now * 2) && !visited[now * 2]) {
                if (times[now * 2] == 0) {
                    q.addLast(now * 2);
                    visited[now * 2] = true;
                    times[now * 2] = times[now];
                }
            }
            if (!isOut(now - 1) && !visited[now - 1]) {
                if (times[now - 1] == 0) {
                    q.addLast(now - 1);
                    visited[now - 1] = true;
                    times[now - 1] = times[now] + 1;
                }
            }
            if (!isOut(now + 1) && !visited[now + 1]) {
                if (times[now + 1] == 0) {
                    q.addLast(now + 1);
                    visited[now + 1] = true;
                    times[now + 1] = times[now] + 1;
                }
            }
        }

        System.out.println(times[k]);
    }

    private static boolean isOut(int now) {
        return now < 0 || 100000 < now;
    }
}