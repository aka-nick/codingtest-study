import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {

    private static int[] dx;
    private static int[] dy;
    private static int[] ddx;
    private static int[] ddy;
    private static Deque<CloudPoint> cq;
    private static Deque<DS> moves;
    private static int[][] a;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(line[j]);
            }
        }
        moves = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            String[] ds = br.readLine().split(" ");
            moves.addLast(new DS(ds));
        }
        br.close();

        /*
        0. 비바라기
        1. 구름 이동 (여덟방향 순회 / 맵 바깥쪽 이동 가능)
        2. 구름 물 증가 (증가한 칸 저장 / 물 증가한 칸 == 구름 이동한 칸 == 구름 제거된 칸)
        3. 구름 삭제 (물 증가 칸 순회...인데 안지우고(5에서 쓰니까) 삭제했다 치고, 실제로는 5 실행 이후 삭제한다)
        4. 물 증가 칸 물 증가 (물 증가 칸 순회 / 대각선 물 체크 / 맵 바깥 이동 불가능 )
        5. 구름 생성 (전체 순회 / 물 증가칸 비교 / 물양 비교)

        6. 전체 순회하며 합계
         */

        dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        dy = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
        ddx = new int[]{1, -1, -1, 1};
        ddy = new int[]{1, 1, -1, -1};

        cq = new ArrayDeque<>();
        // 0. 비바라기
        cq.addLast(new CloudPoint(n - 1, 0));
        cq.addLast(new CloudPoint(n - 1, 1));
        cq.addLast(new CloudPoint(n - 2, 0));
        cq.addLast(new CloudPoint(n - 2, 1));

        for (int p = 0; p < m; p++) {
            moveClouds(); // 1
            increaseWaterInClouds(); // 2
            // 3. 구름 삭제 (물 증가 칸 순회...인데 안지우고(5에서 쓰니까) 삭제했다 치고, 실제로는 5 실행 이후 삭제한다)
            increaseWaterInDiagonal(); // 4
            createClouds(); // 5
        }

        int result = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                result += a[x][y];
            }
        }

        System.out.println(result);
    }

    private static void printWaters() {
        System.out.println("-----------------------");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();
    }

    private static void printClouds(Collection<CloudPoint> cq) {
        int[][] tmp = new int[n][n];
        for (CloudPoint cp : cq) {
            tmp[cp.x][cp.y] = 1;
        }
        System.out.println();
        System.out.println("==================================");
        for (int[] t : tmp) {
            System.out.println(Arrays.toString(t));
        }
        System.out.println();
    }

    private static void moveClouds() {
        // 1. 구름 이동 (여덟방향 순회 / 맵 바깥쪽 이동 가능)
        int size = cq.size();
        DS ds = moves.removeFirst();
        while (size-->0) {
            CloudPoint now = cq.removeFirst();

            int nx = (now.x - (dx[ds.d - 1] * (ds.s % n)) + n) % n;
            int ny = (now.y - (dy[ds.d - 1] * (ds.s % n)) + n) % n;
            cq.addLast(new CloudPoint(nx, ny));
        }
    }

    private static void increaseWaterInClouds() {
        // 2. 구름 물 증가 (증가한 칸 저장 / 물 증가한 칸 == 구름 이동한 칸 == 구름 제거된 칸)
        for (CloudPoint cp : cq) {
            a[cp.x][cp.y]++;
        }
    }

    private static void increaseWaterInDiagonal() {
        // 4. 물 증가 칸 물 증가 (물 증가 칸 순회 / 대각선 물 체크 / 맵 바깥 이동 불가능 )
        for (CloudPoint cp : cq) {
            int ddCount = 0;
            for (int i = 0; i < 4; i++) {
                int nx = cp.x - ddx[i];
                int ny = cp.y - ddy[i];

                if (nx < 0 || ny < 0 || n <= nx || n <= ny) continue;
                if (a[nx][ny] == 0) continue;

                ddCount++;
            }
            a[cp.x][cp.y] += ddCount;
        }
    }

    private static void createClouds() {
        // 5. 구름 생성 (전체 순회 / 물 증가칸 비교 / 물양 비교)...인데 끝나면 3번도 빼먹지 말고.
        // ...로 하려고 했는데 그냥 `!set.contains()` 처럼 푸는게 편할 것 같아서.
        Set<CloudPoint> removedClouds = new HashSet<>();
        while (!cq.isEmpty()) {
            removedClouds.add(cq.removeFirst());
        }
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (a[x][y] < 2) continue;
                if (removedClouds.contains(new CloudPoint(x, y))) continue;
                cq.addLast(new CloudPoint(x, y));
                a[x][y] -= 2;
            }
        }
    }

    static class CloudPoint {
        public int x;
        public int y;

        public CloudPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CloudPoint point = (CloudPoint) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    static class DS {
        public int d;
        public int s;

        public DS(int d, int s) {
            this.d = d;
            this.s = s;
        }
        public DS(String[] ds) {
            this.d = Integer.parseInt(ds[0]);
            this.s = Integer.parseInt(ds[1]);
        }

    }

}
