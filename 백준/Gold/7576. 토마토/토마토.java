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
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();
        int days = 0;

        int exist = 0;
        int notExist = 0;
        int yet = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    q.addLast(new int[]{i, j});
                    visited[i][j] = true;
                    exist++;
                }
                else if (map[i][j] == -1) {
                    notExist++;
                }
                else if (map[i][j] == 0) {
                    yet++;
                }
            }
        }
        if (yet == 0) {
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            days++;

            while (0 < size--) {
                int[] pos = q.pollFirst();

                for (int i = 0; i < 4; i++) {
                    int nextX = pos[0] - dx[i];
                    int nextY = pos[1] - dy[i];

                    if (nextX < 0 || nextY < 0 || n <= nextX || m <= nextY) {
                        continue;
                    }

                    if (!visited[nextX][nextY] && map[nextX][nextY] == 0) {
                        map[nextX][nextY] = 1;
                        visited[nextX][nextY] = true;
                        q.addLast(new int[]{nextX, nextY});
                    }
                }

            }
        }

        yet = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    yet++;
                }
            }
        }
        if (0 < yet) {
            System.out.println(-1);
            return;
        }

        System.out.println(--days);
    }

}