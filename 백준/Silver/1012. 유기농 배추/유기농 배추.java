import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (t-->0) {
            String[] split = br.readLine().split(" ");
            int m = Integer.parseInt(split[0]);
            int n = Integer.parseInt(split[1]);
            int k = Integer.parseInt(split[2]);
            boolean[][] map = new boolean[m + 1][n + 1];
            while (k-->0) {
                String[] sp = br.readLine().split(" ");
                int x = Integer.parseInt(sp[0]);
                int y = Integer.parseInt(sp[1]);

                map[x][y] = true;
            }

            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            Deque<int[]> q = new ArrayDeque<>();
            int count = 0;
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (!map[x][y]) {
                        continue;
                    }

                    q.addLast(new int[]{x, y});
                    map[x][y] = false;
                    count++;

                    while (!q.isEmpty()) {
                        int[] now = q.removeFirst();
                        for (int i = 0; i < 4; i++) {
                            int nx = now[0] - dx[i];
                            int ny = now[1] - dy[i];

                            if (nx < 0 || ny < 0 || m < nx || n < ny) {
                                continue;
                            }
                            if (!map[nx][ny]) {
                                continue;
                            }

                            map[nx][ny] = false;
                            q.addLast(new int[]{nx, ny});
                        }
                    }
                }
            }
            result.append(count).append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}