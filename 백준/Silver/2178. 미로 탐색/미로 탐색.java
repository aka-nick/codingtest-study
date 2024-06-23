import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[][] map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                map[i][j] = chars[j - 1] - '0';
            }
        }
        br.close();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[n + 1][m + 1];

        Deque<int[]> d = new ArrayDeque<>();
        d.addLast(new int[]{1, 1});
        visited[1][1] = true;

        int step = 0;
        while (!d.isEmpty()) {
            int size = d.size();
            step++;

            while (size-->0) {
                int[] now = d.removeFirst();

                for (int i = 0; i < 4; i++) {
                    int nextX = now[0] - dx[i];
                    int nextY = now[1] - dy[i];

                    if (nextX < 1 || nextY < 1 || n < nextX || m < nextY) {
                        continue;
                    }
                    if (visited[nextX][nextY]) {
                        continue;
                    }
                    if (map[nextX][nextY] == 0) {
                        continue;
                    }

                    if (nextX == n && nextY == m) {
                        // 종료조건
                        visited[nextX][nextY] = true;
                        System.out.println(step + 1);
                        return;
                    }

                    d.addLast(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
    
}