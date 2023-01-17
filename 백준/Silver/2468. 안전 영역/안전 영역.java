import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        StringTokenizer st;
        List<Integer> mtHeights = new ArrayList<>(); // 산의 높이들
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                mtHeights.add(num);
            }
        }
        br.close();

        mtHeights = mtHeights.stream()
                .sorted((o1, o2) -> o2 - o1)
                .distinct()
                .collect(Collectors.toList());

        int countOfArea = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (Integer mtHeight : mtHeights) {
            int height = mtHeight - 1; // 해당 산이 안전지대가 되는 최대 높이

            Deque<int[]> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[n][n];
            int countOfNowArea = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {

                    if (height < map[x][y] && !visited[x][y]) {
                        visited[x][y] = true;
                        q.addLast(new int[]{x, y});
                        countOfNowArea++;

                        while (!q.isEmpty()) {
                            int size = q.size();

                            while (size-- > 0) {
                                int[] pos = q.pollFirst();
                                for (int i = 0; i < 4; i++) {
                                    int nx = pos[0] - dx[i];
                                    int ny = pos[1] - dy[i];

                                    if (nx < 0 || ny < 0 || n <= nx || n <= ny) {
                                        continue;
                                    }
                                    if (map[nx][ny] <= height) {
                                        continue;
                                    }
                                    if (visited[nx][ny]) {
                                        continue;
                                    }

                                    visited[nx][ny] = true;
                                    q.addLast(new int[]{nx, ny});
                                }
                            }
                        }

                        countOfArea = Math.max(countOfArea, countOfNowArea);
                    }

                }
            }

        }

        System.out.println(countOfArea);
    }

}