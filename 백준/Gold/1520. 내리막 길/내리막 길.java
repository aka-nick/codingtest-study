import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[][] map;
    private static int[][] dp;
    private static int[] dx;
    private static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < m; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }
    private static int dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            return 1;
        }
        
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x - dx[i];
            int ny = y - dy[i];

            if (nx < 0 || ny < 0 || n <= nx || m <= ny) continue;

            if (map[x][y] > map[nx][ny]) {
                dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }
}