import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] map = new int[h][n][m];
        List<int[]> ripes = new ArrayList<>();
        for (int hh = 0; hh < h; hh++) {
            for (int nn = 0; nn < n; nn++) {
                st = new StringTokenizer(br.readLine());
                for (int mm = 0; mm < m; mm++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    map[hh][nn][mm] = tomato;
                    if (tomato == 1) {
                        ripes.add(new int[]{hh, nn, mm});
                    }
                }
            }
        }
        br.close();

        int[] dh = {0, 0, 0, 0, 1, -1};
        int[] dx = {1, 0, -1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        Deque<int[]> q = new ArrayDeque<>();

        for (int[] ripe : ripes) {
            q.addLast(new int[]{ripe[0], ripe[1], ripe[2]});
        }

        int days = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            days++;

            while (size-- > 0) {
                int[] pos = q.pollFirst();
                for (int i = 0; i < 6; i++) {
                    int nh = pos[0] - dh[i];
                    int nx = pos[1] - dx[i];
                    int ny = pos[2] - dy[i];

                    if (nh < 0 || nx < 0 || ny < 0 || h <= nh || n <= nx || m <= ny) {
                        continue;
                    }
                    if (map[nh][nx][ny] == -1) {
                        continue;
                    }
                    if (map[nh][nx][ny] == 1) {
                        continue;
                    }

                    q.addLast(new int[]{nh, nx, ny});
                    map[nh][nx][ny] = 1;
                }
            }
        }

        if (haveUnripes(m, n, h, map)) {
            System.out.println(-1);
            return;
        }

        System.out.println(--days);
    }

    private static boolean haveUnripes(int m, int n, int h, int[][][] map) {
        for (int hh = 0; hh < h; hh++) {
            for (int nn = 0; nn < n; nn++) {
                for (int mm = 0; mm < m; mm++) {
                    if (map[hh][nn][mm] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}