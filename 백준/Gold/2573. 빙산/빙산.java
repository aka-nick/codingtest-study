import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        visited = null;
        Deque<Position> q = new ArrayDeque<>();
        int step = 0;

        while (existGlacier()) {

            // 두 덩어리 되었는지 탐색(전체 지역을 훑다가 빙하를 찾으면 연결된 땅을 전부 방문하고, 이후에 방문하지 않았던 지역을 훑다가 또 빙하가 나오면 나눠진 걸로 판정)
            if (isTwoGlacier(n, m, dx, dy, q, step)) {
                return;
            }

            // 이번 스텝 빙하녹이기 실행: 이전 스텝의 빙하 주변에 있는 바다를 카운트해서(countOfSea), 현스텝 빙하를 계산(이전스텝빙하 - 카운트된바다)하여 저장.
            step++;
            int[][] meltMap = copyMap(n, m); // 한번에 녹이기 위해 복사본 마련
            meltingGlacier(n, m, dx, dy, meltMap);
        }

        System.out.println(0); //둘로 나눠지지 않고 다 녹은 경우(끝까지 한 덩어리였던 경우): 0 출력
    }

    private static void meltingGlacier(int n, int m, int[] dx, int[] dy, int[][] meltMap) {
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {

                if (isMelted(meltMap[i][j])) continue;

                int countOfSea = 0;
                for (int k = 0; k < 4; k++) {
                    if (isMelted(meltMap[i - dx[k]][j - dy[k]])) countOfSea++;
                }
                map[i][j] = meltMap[i][j] - countOfSea;
            }
        }
    }

    private static int[][] copyMap(int n, int m) {
        int[][] meltMap = new int[n][];
        for (int i = 0; i < n; i++) {
            meltMap[i] = Arrays.copyOf(map[i], m);
        }
        return meltMap;
    }

    private static boolean isTwoGlacier(int n, int m, int[] dx, int[] dy, Deque<Position> q,
            int step) {
        visited = new boolean[n][m];
        boolean isAlreadySearch = false;
        for(int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {

                if (!visited[i][j] && 0 < map[i][j]) {
                    if (isAlreadySearch) { // 종료조건 도달: 이미 탐색 실행했는데 또 다른 땅이 나타난 상황
                        System.out.println(step);
                        return true;
                    }
                    isAlreadySearch = true;
                    visited[i][j] = true;
                    q.addLast(new Position(i, j));
                    while (!q.isEmpty()) {
                        Position pos = q.pollFirst();
                        for (int k = 0; k < 4; k++) {
                            int nx = pos.x - dx[k];
                            int ny = pos.y - dy[k];

                            if (visited[nx][ny]) continue;
                            if (isMelted(map[nx][ny])) continue;

                            visited[nx][ny] = true;
                            q.addLast(new Position(nx, ny));
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean isMelted(int glacierPoint) {
        return glacierPoint <= 0;
    }

    private static boolean existGlacier() {
        for (int[] ints : map) {
            for (int anInt : ints) {
                if (0 < anInt) return true;
            }
        }
        return false;
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