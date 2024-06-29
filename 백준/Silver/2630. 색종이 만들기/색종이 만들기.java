import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[][] map;
    private static int wCount = 0;
    private static int bCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] numbers = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        br.close();

        doOrigami(0, 0, n);

        System.out.println(wCount);
        System.out.println(bCount);
    }

    private static void doOrigami(int x, int y, int size) {
        boolean isAllSame = true;
        compare:
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[x][y] != map[i][j]) {
                    isAllSame = false;
                    break compare;
                }
            }
        }
        if (isAllSame) {
            if (map[x][y] == 0) {
                wCount++;
            } else {
                bCount++;
            }
            return;
        }

        int halfSize = size / 2;
        doOrigami(x, y, halfSize);
        doOrigami(x, y + halfSize, halfSize);
        doOrigami(x + halfSize, y, halfSize);
        doOrigami(x + halfSize, y + halfSize, halfSize);
    }

}