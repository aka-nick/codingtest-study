import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int NO_ENTRY = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Rectangle> rects = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            rects.add(new Rectangle(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
        br.close();

        int[][] map = new int[n][m];
        for (Rectangle rect : rects) {
            for (int i = rect.start.x; i <= rect.end.x; i++) {
                for (int j = rect.start.y; j <= rect.end.y; j++) {
                    map[i][j] = NO_ENTRY;
                }
            }
        }

        int countOfArea = 0 ;
        List<Integer> dimOfAreas = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Deque<Position> q = new ArrayDeque<>();

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (!isVisited(map, x, y)) {
                    countOfArea++;

                    int dimension = 0;
                    dimension += visit(map, q, x, y);

                    while (!q.isEmpty()) {
                        Position pos = q.pollFirst();
                        for (int i = 0; i < 4; i++) {
                            int nx = pos.x - dx[i];
                            int ny = pos.y - dy[i];

                            if (nx < 0 || ny < 0 || n <= nx || m <= ny || map[nx][ny] == NO_ENTRY) {
                                continue;
                            }
                            if (isVisited(map, nx, ny)) {
                                continue;
                            }

                            dimension += visit(map, q, nx, ny);
                        }
                    }
                    dimOfAreas.add(dimension);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(countOfArea).append(System.lineSeparator());
        dimOfAreas.stream()
                .sorted()
                .forEach(i -> result.append(i).append(' '));
        System.out.println(result);
    }

    private static int visit(int[][] map, Deque<Position> q, int x, int y) {
        q.addLast(new Position(x, y));
        map[x][y] = 1;

        return 1;
    }

    private static boolean isVisited(int[][] map, int x, int y) {
        return map[x][y] != 0;
    }

    static class Rectangle {
        Position start;
        Position end;

        public Rectangle(int a, int b, int c, int d) {
            this.start = new Position(b, a);
            this.end = new Position(d - 1, c - 1);
        }
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