import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static final int WALL = 1;
    private static final int ENTRY_ALL = 0;
    private static final int ENTRY_CANBREAK = -1;
    private static final int ENTRY_NOONE = -2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int targetX = n - 1;
        int targetY = m - 1;
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            if (chars.length == 0) {
                i--;
                continue;
            }
            for (int j = 0; j < m; j++) {
                map[i][j] = chars[j] - '0';
            }
        }
        br.close();

        if (0 == targetX && 0 == targetY) {
            System.out.println(1);
            return;
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Deque<Position> q = new ArrayDeque<>();
        int[][] visited = new int[n][m];
        int step = 0;

        q.addLast(new Position(0, 0));
        visited[0][0] = ENTRY_NOONE;

        while (!q.isEmpty()) {
            int size = q.size();
            step++;

            while (size-- > 0) {
                Position pos = q.pollFirst();
                if (pos.x == targetX && pos.y == targetY) { //종료조건
                    System.out.println(step);
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int visitNumber = ENTRY_NOONE;
                    int nx = pos.x - dx[i];
                    int ny = pos.y - dy[i];

                    if (nx < 0 || ny < 0 || targetX < nx || targetY < ny) {
                        continue;
                    }
                    boolean canBreak = pos.canBreak;
                    if (!canBreak && map[nx][ny] == WALL) {
                        continue;
                    }

                    if (canBreak && map[nx][ny] == WALL) {
                        canBreak = false;
                    }
                    if (!canBreak) {
                        visitNumber = ENTRY_CANBREAK;
                    }

                    if (visited[nx][ny] <= visitNumber) {
                        continue;
                    }

                    visited[nx][ny] = visitNumber;
                    q.addLast(new Position(nx, ny, canBreak));
                }

            }
        }

        System.out.println(-1); // 여기까지 오면 실패
    }

    static class Position {
        int x;
        int y;
        boolean canBreak;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
            this.canBreak = true;
        }

        public Position(int x, int y, boolean canBreak) {
            this.x = x;
            this.y = y;
            this.canBreak = canBreak;
        }

    }

}