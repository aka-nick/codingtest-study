import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final char SWAN = 'L';
    private static final char WATER = '.';
    private static final char ICE = 'X';
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static int r;
    private static int c;
    private static char[][] map;
    private static boolean[][] visited;
    private static List<Position> swan = new ArrayList<>();
    private static Deque<Position> lq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        for (int x = 0; x < r; x++) {
            map[x] = br.readLine().toCharArray();
            for (int y = 0; y < c; y++) {
                if (map[x][y] == SWAN) {
                    swan.add(new Position(x, y));
                }
                if (map[x][y] != ICE) {
                    lq.addLast(new Position(x, y));
                }
            }
        }
        br.close();

        Deque<Position>[] q = new ArrayDeque[2]; //0번은 현재탐색, 1번은 다음에 탐색해야할 지점
        q[0] = new ArrayDeque<>();
        q[0].addLast(swan.get(0));
        visited[swan.get(0).x][swan.get(0).y] = true;

        int days = 0;
        search:
        while (true) {
            
            // 이번 탐색을 진행하며 다음번 탐색 시작 지역(아직 얼음인 곳)을 찾는다
            q[1] = new ArrayDeque<>();
            while (!q[0].isEmpty()) {
                Position pos = q[0].pollFirst();

                if (pos.x == swan.get(1).x && pos.y == swan.get(1).y) { // 종료 조건: 탐색하다가 다른 오리 찾는 경우
                    break search;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = pos.x - dx[i];
                    int ny = pos.y - dy[i];

                    if (nx < 0 || ny < 0 || r <= nx || c <= ny) continue;
                    if (visited[nx][ny]) continue;

                    visited[nx][ny] = true;
                    if (map[nx][ny] == ICE) {
                        q[1].addLast(new Position(nx, ny));
                    }
                    else {
                        q[0].addLast(new Position(nx, ny));
                    }
                }
            }

            q[0] = q[1]; // 다음 탐색할 지역을 장전(?)
            days++;

            // 얼음을 녹인다
            int size = lq.size();
            while (size-- > 0) {
                Position pos = lq.pollFirst();
                for (int i = 0; i < 4; i++) {
                    int nx = pos.x - dx[i];
                    int ny = pos.y - dy[i];

                    if (nx < 0 || ny < 0 || r <= nx || c <= ny) continue;

                    if (map[nx][ny] == ICE) {
                        map[nx][ny] = WATER;
                        lq.offer(new Position(nx, ny));
                    }
                }
            }
        }

        System.out.println(days);

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