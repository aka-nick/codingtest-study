import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        br.close();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> q = new ArrayDeque<>();

        // 적 녹 청 탐색
        int rgbGroup = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (!visited[x][y]) {
                    q.addLast(new int[]{x, y});
                    visited[x][y] = true;
                    char nowColor = map[x][y];
                    rgbGroup++;
                    recolorGreenTile(map, x, y, nowColor);

                    while (!q.isEmpty()) {
                        int[] pos = q.pollFirst();
                        for (int i = 0; i < 4; i++) {
                            int nx = pos[0] - dx[i];
                            int ny = pos[1] - dy[i];

                            if (visit(n, map, visited, q, nowColor, nx, ny)) {
                                continue;
                            }

                            recolorGreenTile(map, nx, ny, nowColor);
                        }
                    }
                }
            }
        }

        visited = new boolean[n][n];
        // 적녹 청 탐색
        int rbGroup = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (!visited[x][y]) {
                    q.addLast(new int[]{x, y});
                    visited[x][y] = true;
                    char nowColor = map[x][y];
                    rbGroup++;

                    while (!q.isEmpty()) {
                        int[] pos = q.pollFirst();
                        for (int i = 0; i < 4; i++) {
                            int nx = pos[0] - dx[i];
                            int ny = pos[1] - dy[i];

                            visit(n, map, visited, q, nowColor, nx, ny);
                        }
                    }
                }
            }
        }

        System.out.println(rgbGroup + " " + rbGroup);

    }

    private static boolean visit(int n, char[][] map, boolean[][] visited, Deque<int[]> q,
            char nowColor, int nx, int ny) {
        if (nx < 0 || ny < 0 || n <= nx || n <= ny) {
            return true;
        }
        if (visited[nx][ny]) {
            return true;
        }
        if (nowColor != map[nx][ny]) {
            return true;
        }

        q.addLast(new int[]{nx, ny});
        visited[nx][ny] = true;
        return false;
    }

    private static void recolorGreenTile(char[][] map, int x, int y, char nowColor) {
        if (nowColor == 'G') { // 적녹 청 탐색을 위한 맵 컬러 재배치
            map[x][y] = 'R';
        }
    }

}