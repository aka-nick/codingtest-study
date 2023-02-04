import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    /*
    0,0부터 n-1, n-1까지 탐색하면서
        바다와 접해있는 땅(1)을 찾는다.
        찾았으면, 땅과 접해있는 바다(0)를 탐색큐에 넣고, 다른 땅(???)을 만날 때까지 탐색을 계속하면서
            다른 땅을 만났으면, 그때까지의 거리를 max=Max(max,거리)로 저장한다
    max를 출력한다

    ---
    다른 땅인지를 어떻게 구분해줄까? 예를 들어 아래의 경우.
    ...
    1 1@1 0
    1@0 1*0
    1@0 0 0
    0 0 0 1#
    ...
    1*와 면한 바다에서 출발한 경우, 1#에 도달해야 다른 땅이지만, 1@와 같은 바다를 면한 또다른 자신의 땅에 도착할 수도 있다.

    그러면 먼저,
    - 모든 땅을 탐색하면서 같은 땅마다 1 이상의 정수로 구분해주는 작업을 해야겠다. 그러면 땅의 정의는 1에서 1 이상의 정수가 된다.
    근데 두 번 탐색할 시간이 되나? 일단 해보지 뭐..

    ---
    visited 배열을 사용해야 한다. 이미 탐색 실패한 바다를 재탐색하는 일이 일어나지 않기 위해.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[n][n];
        Deque<Position> q = new ArrayDeque<>();

        int recolor = 0;
        // 모든 땅을 탐색하면서 같은 땅마다 1 이상의 정수로 구분
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    q.addLast(new Position(i, j));
                    visited[i][j] = true;
                    map[i][j] = ++recolor;

                    while (!q.isEmpty()) {
                        Position pos = q.pollFirst();
                        for (int k = 0; k < 4; k++) {
                            int nx = pos.x - dx[k];
                            int ny = pos.y - dy[k];

                            if (nx < 0 || ny < 0 || n <= nx || n <= ny) {
                                continue;
                            }
                            if (visited[nx][ny]) {
                                continue;
                            }
                            if (map[nx][ny] == 0) {
                                continue;
                            }

                            map[nx][ny] = recolor;
                            visited[nx][ny] = true;
                            q.addLast(new Position(nx, ny));
                        }
                    }
                }
            }
        }

//        for (int[] ints : map) {
//            System.out.println(Arrays.toString(ints));
//        }

        //0,0부터 n-1, n-1까지 탐색하면서
        int min = Integer.MAX_VALUE;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                //        바다와 접해있는 땅(1 이상)을 찾는다.
                if (0 < map[x][y]) {
                    int nowLand = map[x][y];
                    for (int i = 0; i < 4; i++) {
                        visited = new boolean[n][n];
                        int sx = x - dx[i];
                        int sy = y - dy[i];

                        if (sx < 0 || sy < 0 || n <= sx || n <= sy) {
                            continue;
                        }
                        if (visited[sx][sy]) {
                            continue;
                        }
                        if (map[sx][sy] != 0) {
                            continue;
                        }

                        q.addLast(new Position(sx, sy));
                        visited[sx][sy] = true;

        //        찾았으면, 땅과 접해있는 바다(0)를 탐색큐에 넣고, 다른 땅(???)을 만날 때까지 탐색을 계속하면서
                        int step = 0;
                        while (!q.isEmpty()) {
                            step++;
                            int size = q.size();
                            while (size-- > 0) {
                                Position pos = q.pollFirst();
                                for (int j = 0; j < 4; j++) {
                                    int nx = pos.x - dx[j];
                                    int ny = pos.y - dy[j];

                                    if (nx < 0 || ny < 0 || n <= nx || n <= ny) {
                                        continue;
                                    }
                                    if (visited[nx][ny]) {
                                        continue;
                                    }
                                    if (map[nx][ny] == nowLand) {
                                        continue;
                                    }

        //            다른 땅을 만났으면, 그때까지의 거리를 max=Max(max,거리)로 저장한다 -> 제일 짧은걸 출력해야 한다.. 바보야..
                                    if (1 <= map[nx][ny]) { // 다리 완성
//                                        System.out.println(nowLand + " [" +sx +","+sy+ "]  :  " + map[nx][ny] + "[" +nx +","+ny+ "]   ---   nowMin is " + min + "   ---   nowStep is " + step);
                                        min = Math.min(min, step);
                                        continue;
                                    }

                                    visited[nx][ny] = true;
                                    q.addLast(new Position(nx, ny));
                                }
                            }
                        }
                    }

                }
            }
        }
        //    max를 출력한다
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        System.out.println(min);

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