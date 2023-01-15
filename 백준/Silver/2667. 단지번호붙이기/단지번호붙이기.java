import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = chars[j] - '0';
            }
        }
        br.close();

        StringBuilder result = new StringBuilder();
        int numberOfArea = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> q = new ArrayDeque<>();
        List<Integer> areas = new LinkedList<>();

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                int area = 0;
                if (map[x][y] != 0 && !visited[x][y]) {
                    map[x][y] = ++numberOfArea;
                    area++;
                    q.addLast(new int[]{x, y});
                    visited[x][y] = true;

                    while (!q.isEmpty()) {
                        int[] pos = q.pollFirst();
                        for (int i = 0; i < 4; i++) {
                            int nx = pos[0] - dx[i];
                            int ny = pos[1] - dy[i];

                            if (nx < 0 || ny < 0 || n <= nx || n <= ny) {
                                continue;
                            }
                            if (map[nx][ny] == 0 || visited[nx][ny]) {
                                continue;
                            }

                            map[nx][ny] = numberOfArea;
                            area++;
                            q.addLast(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                    areas.add(area);
                }
            }
        }

        result.append(numberOfArea).append(System.lineSeparator());
        areas.stream()
                .sorted()
                .forEach(i -> result.append(i).append(System.lineSeparator()));

        System.out.println(result);
    }
}