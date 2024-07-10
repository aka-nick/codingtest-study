import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[n][n];
        for (int x = 0; x < n; x++) {
            char[] chars = br.readLine().toCharArray();
            for (int y = 0; y < n; y++) {
                map[x][y] = chars[y] == '1';
            }
        }
        br.close();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Deque<int[]> q = new ArrayDeque<>();

        int count = 0;
        List<Integer> homeCounts = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (!map[x][y]) continue;

                int homeCount = 0;
                q.addLast(new int[]{x, y});
                map[x][y] = false;
                count++;
                homeCount++;
                while (!q.isEmpty()) {
                    int[] now = q.removeFirst();
                    for (int i = 0; i < 4; i++) {
                        int nx = now[0] - dx[i];
                        int ny = now[1] - dy[i];

                        if (nx < 0 || ny < 0 || n <= nx || n <= ny) continue;
                        if (!map[nx][ny]) continue;

                        q.addLast(new int[]{nx, ny});
                        map[nx][ny] = false;
                        homeCount++;
                    }
                }

                homeCounts.add(homeCount);
            }
        }

        result.append(count).append(System.lineSeparator());
        homeCounts.stream()
                .sorted()
                .forEach(c -> result.append(c).append(System.lineSeparator()));

        System.out.println(result);
    }

}