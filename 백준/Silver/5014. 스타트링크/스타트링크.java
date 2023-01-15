import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        br.close();

        if (start == dest) {
            System.out.println(0);
            return;
        }

        int[] dp = {up, -down};
        int[] map = new int[max + 1];
        Arrays.fill(map, -1);
        map[0] = 0; // 없는 층 체크
        int step = 0;
        Deque<Integer> q = new ArrayDeque<>();
        map[start] = step;
        q.addLast(start);

        while (!q.isEmpty()) {
            int size = q.size();
            step++;

            while (size-- > 0) {
                int pos = q.pollFirst();
                for (int i = 0; i < 2; i++) {
                    int np = pos + dp[i];

                    if (np < 0 || max < np) {
                        continue;
                    }
                    if (map[np] != -1) {
                        continue;
                    }

                    if (np == dest) {
                        System.out.println(step);
                        return;
                    }

                    map[np] = step;
                    q.addLast(np);
                }
            }
        }

        System.out.println("use the stairs");
    }
}