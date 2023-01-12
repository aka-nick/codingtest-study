import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    private static final int NO_ENTRY = Integer.MIN_VALUE;
    private static final int ENTRY = Integer.MAX_VALUE;
    private static final char WALL = '#';
    private static final char JIHUN = 'J';
    private static final char FIRE = 'F';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] jihunPos = {};
        List<int[]> firePosList = new ArrayList<>();
        boolean[][] fireVisited = new boolean[n][m];
        boolean[][] jihunVisited = new boolean[n][m];
        int[][] fireMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            if (chars.length == 0) {
                i--;
                continue;
            }
            for (int j = 0; j < m; j++) {
                char c = chars[j];

                if (c == WALL) {
                    fireMap[i][j] = NO_ENTRY;
                    fireVisited[i][j] = true;
                    jihunVisited[i][j] = true;
                } else if (c == JIHUN) {
                    jihunPos = new int[]{i, j};
                    fireMap[i][j] = ENTRY;
                } else if (c == FIRE) {
                    firePosList.add(new int[]{i, j});
                } else {
                    fireMap[i][j] = ENTRY;
                }
            }
        }
        br.close();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Deque<int[]> q = new ArrayDeque<>();

        // 불 탐색
        int time = 0;
        for (int[] pos : firePosList) {
            q.addLast(pos);
            fireVisited[pos[0]][pos[1]] = true;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            while (0 < size--) {
                int[] pos = q.pollFirst();

                for (int i = 0; i < 4; i++) {
                    int nx = pos[0] - dx[i];
                    int ny = pos[1] - dy[i];

                    if (nx < 0 || ny < 0 || n <= nx || m <= ny) {
                        continue;
                    }

                    if (!fireVisited[nx][ny] &&  time < fireMap[nx][ny]) {
                        q.addLast(new int[]{nx, ny});
                        fireVisited[nx][ny] = true;
                        fireMap[nx][ny] = time;
                    }
                }
            }
        }

        // 지훈이 탐색
        time = 0;
        int x = jihunPos[0];
        int y = jihunPos[1];
        if (0 < fireMap[x][y]) {
            if (x == 0 || y == 0 || x == n - 1 || y == n - 1) {
                System.out.println(++time);
                return;
            }
            q.addLast(jihunPos);
            jihunVisited[jihunPos[0]][jihunPos[1]] = true;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            while (0 < size--) {
                int[] pos = q.pollFirst();

                for (int i = 0; i < 4; i++) {
                    int nx = pos[0] - dx[i];
                    int ny = pos[1] - dy[i];

                    if (fireMap[nx][ny] != NO_ENTRY &&
                            time < fireMap[nx][ny] &&
                            (nx == 0 || ny == 0 || n - 1 == nx || m - 1 == ny)) { // 탈출 성공
                        System.out.println(++time);
                        return;
                    }

                    if (!jihunVisited[nx][ny] && time < fireMap[nx][ny]) {
                        q.addLast(new int[]{nx, ny});
                        jihunVisited[nx][ny] = true;
                    }

                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

}