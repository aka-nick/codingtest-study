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
        int[][] canvas = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                canvas[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int countOfPaint = 0;
        int maxSize = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                int size = 0;

                if (canvas[x][y] == 1 && !visited[x][y]) {
                    q.addLast(new int[]{x, y});
                    visited[x][y] = true;
                    size = 1;
                    countOfPaint++;
                }

                while (!q.isEmpty()) {
                    int[] now = q.pollFirst();
                    int nowX = now[0];
                    int nowY = now[1];

                    for (int i = 0; i < 4; i++) {
                        int newX = nowX + dx[i];
                        int newY = nowY + dy[i];

                        if (newX < 0 || newY < 0 || n <= newX || m <= newY ||
                                canvas[newX][newY] == 0 ||
                                visited[newX][newY]) {
                            continue;
                        }

                        q.addLast(new int[]{newX, newY});
                        visited[newX][newY] = true;
                        size++;
                    }
                }

                maxSize = Math.max(size, maxSize);
            }
        }

        System.out.println(countOfPaint);
        System.out.println(maxSize);
    }

}