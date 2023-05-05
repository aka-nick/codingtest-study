import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final char WALL = '#';
    private static final int WALL_VALUE = -1;
    private static final char JIHUN = 'J';
    private static final char FIRE = 'F';
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        List<Position> fireStarting = new ArrayList<>();
        Position jihunStarting = null;
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (chars[j] == FIRE) {
                    fireStarting.add(new Position(i, j));
                } else if (chars[j] == JIHUN) {
                    jihunStarting = new Position(i, j);
                } else if (chars[j] == WALL) {
                    map[i][j] = WALL_VALUE;
                }
            }
        }
        br.close();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Deque<Position> q = new ArrayDeque<>();

        // fire run
        boolean[][] fireVisited = new boolean[n][m];
        int fireStep = 1;
        for (Position pos : fireStarting) {
            q.addLast(pos);
            map[pos.x][pos.y] = fireStep;
            fireVisited[pos.x][pos.y] = true;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            fireStep++;
            while (size-- > 0) {
                Position now = q.pollFirst();
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if (nx < 0 || ny < 0 || n <= nx || m <= ny) continue;
                    if (fireVisited[nx][ny]) continue;
                    if (map[nx][ny] != 0 && map[nx][ny] < fireStep) continue;

                    map[nx][ny] = fireStep;
                    q.addLast(new Position(nx, ny));
                    fireVisited[nx][ny] = true;
                }
            }
        }

        // jihun run
        boolean[][] jihunVisited = new boolean[n][m];
        int jihunStep = 1;
        q.addLast(jihunStarting);
        map[jihunStarting.x][jihunStarting.y] = jihunStep;
        jihunVisited[jihunStarting.x][jihunStarting.y] = true;
        if (jihunStarting.x == 0 || jihunStarting.y == 0 || n - 1 == jihunStarting.x || m - 1 == jihunStarting.y) { // 최소사이즈(1) 예외처리
            System.out.println(jihunStep);
            return;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            jihunStep++;
            while (size-- > 0) {
                Position now = q.pollFirst();
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (jihunVisited[nx][ny]) continue;
                    if (map[nx][ny] == WALL_VALUE) continue;
                    if (map[nx][ny] != 0 && map[nx][ny] <= jihunStep) continue;

                    if (nx == 0 || ny == 0 || n - 1 == nx || m - 1 == ny) {
                        System.out.println(jihunStep);
                        return;
                    }

                    map[nx][ny] = jihunStep;
                    q.addLast(new Position(nx, ny));
                    jihunVisited[nx][ny] = true;
                }
            }
        }

        System.out.println(IMPOSSIBLE);
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}