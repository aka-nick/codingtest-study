import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int numberOfCabbage = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][m];
            for (int i = 0; i < numberOfCabbage; i++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            boolean[][] visited = new boolean[n][m];
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            Deque<int[]> q = new ArrayDeque<>();

            int numberOfWorm = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (!visited[x][y] && map[x][y] == 1) {
                        q.addLast(new int[]{x, y});
                        visited[x][y] = true;
                        numberOfWorm++;

                        while (!q.isEmpty()) {
                            int[] pos = q.pollFirst();
                            for (int i = 0; i < 4; i++) {
                                int nx = pos[0] - dx[i];
                                int ny = pos[1] - dy[i];

                                if (nx < 0 || ny < 0 || n <= nx || m <= ny ||
                                        visited[nx][ny] ||
                                        map[nx][ny] == 0) {
                                    continue;
                                }

                                q.addLast(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }

            result.append(numberOfWorm).append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }
}