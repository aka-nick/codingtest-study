import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int m;
    private static int n;
    private static List<Position> homes;
    private static List<Position> stores;
    private static Integer[] selectedStore;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        homes = new ArrayList<>();
        stores = new ArrayList<>();
        int[][] map = new int[n][n];
        for (int x = 0; x < n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < n; y++) {
                int now = Integer.parseInt(st.nextToken());
                map[x][y] = now;

                if (now == 1) {
                    homes.add(new Position(x, y));
                }
                else if (now == 2) {
                    stores.add(new Position(x, y));
                }
            }
        }
        br.close();

        selectedStore = new Integer[m];

        bt(0);

        System.out.println(result);
    }

    private static void bt(int numberOfSelectedStore) {
        if (numberOfSelectedStore == m) {
            // 가게들과 집들의 거리를 합산해서 최저 거리를 저장 :
            //      직접 탐색할 필요 없이 거리의 차를 절대값으로 씌우면 집-가게 거리가 나온다. 거리의 최소값들을 합하면 원하는 출력값을 얻을 수 있다.
            int totalDistance = 0;
            for (Position nowHome : homes) {
                int minDistanceOfHomeToStore = Integer.MAX_VALUE;
                for (int i = 0; i < selectedStore.length; i++) {
                    Position nowStore = stores.get(selectedStore[i]);
                    int distanceOfHomeToStore =
                            Math.abs(nowHome.x - nowStore.x) + Math.abs(nowHome.y - nowStore.y);
                    minDistanceOfHomeToStore =
                            Math.min(minDistanceOfHomeToStore, distanceOfHomeToStore);
                }
                totalDistance += minDistanceOfHomeToStore;
            }
            result = Math.min(result, totalDistance);
            return;
        }

        int start = numberOfSelectedStore == 0 ? 0 : selectedStore[numberOfSelectedStore - 1] + 1;
        for (int storeIdx = start; storeIdx < stores.size(); storeIdx++) {
            selectedStore[numberOfSelectedStore] = storeIdx;
            bt(numberOfSelectedStore + 1);
            selectedStore[numberOfSelectedStore] = null;
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