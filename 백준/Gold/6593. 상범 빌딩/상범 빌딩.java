import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static final char START = 'S';
    private static final char END = 'E';
    private static final char WALL = '#';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        while (true) {
            String readline = br.readLine();
            if ("0 0 0".equals(readline.trim())) {
                break;
            }

            StringTokenizer st = new StringTokenizer(readline);
            int h = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            char[][][] map = new char[h][n][m];
            boolean[][][] visited = new boolean[h][n][m];
            Position sPos = new Position();
            Position ePos = new Position();

            for (int hh = 0; hh < h; hh++) {
                for (int nn = 0; nn < n; nn++) {
                    char[] chars = br.readLine().toCharArray();
                    for (int mm = 0; mm < m; mm++) {
                        char c = chars[mm];
                        map[hh][nn][mm] = c;

                        if (c == START) {
                            sPos.h = hh;
                            sPos.x = nn;
                            sPos.y = mm;
                        }
                        else if (c == END) {
                            ePos.h = hh;
                            ePos.x = nn;
                            ePos.y = mm;
                        }
                        else if (c == WALL) {
                            visited[hh][nn][mm] = true;
                        }
                    }
                }
                br.readLine(); //한 층마다 한 줄 씩 입력되는 공백 제거용
            }

            int[] dh = {0, 0, 0, 0, 1, -1};
            int[] dx = {1, 0, -1, 0, 0, 0};
            int[] dy = {0, 1, 0, -1, 0, 0};
            Deque<Position> q = new ArrayDeque<>();
            int step = 0;
            q.addLast(sPos);
            visited[sPos.h][sPos.x][sPos.y] = true;
            boolean isImpossible = true;

            search:
            while (!q.isEmpty()) {
                int size = q.size();
                step++;

                while (size-- > 0) {
                    Position pos = q.pollFirst();

                    for (int i = 0; i < 6; i++) {
                        int nh = pos.h - dh[i];
                        int nx = pos.x - dx[i];
                        int ny = pos.y - dy[i];

                        if (nh == ePos.h && nx == ePos.x && ny == ePos.y) {
                            isImpossible = false;
                            result.append("Escaped in ").append(step).append(" minute(s).").append(System.lineSeparator());
                            break search;
                        }

                        if (nh < 0 || nx < 0 || ny < 0 ||
                                h <= nh || n <= nx || m <= ny) {
                            continue;
                        }
                        if (visited[nh][nx][ny]) {
                            continue;
                        }

                        q.addLast(new Position(nh, nx, ny));
                        visited[nh][nx][ny] = true;
                    }
                }
            }

            if (isImpossible) {
                result.append("Trapped!").append(System.lineSeparator());
            }

        }
        br.close();

        System.out.println(result);
    }

    static class Position {
        int h;
        int x;
        int y;

        public Position() {
        }

        public Position(int h, int x, int y) {
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }
}