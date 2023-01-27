import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int WHITE = 0;
    private static final int BLUE = 1;
    static int countOfWhite = 0;
    static int countOfBlue = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        countConfetti(n, 0, 0);

        System.out.println(countOfWhite);
        System.out.println(countOfBlue);
    }

    private static void countConfetti(int n, int x, int y) {
        if (n == 1) {
            baseCase(n, x, y);
            return;
        }

        int standardColor = map[x][y];
        boolean isAllSame = isAllSame(n, x, y, standardColor);
        if (isAllSame) {
            if (standardColor == WHITE) {
                countOfWhite++;
            }
            else {
                countOfBlue++;
            }
        }
        else {
            int nextSize = n / 2;
            countConfetti(nextSize, x, y);
            countConfetti(nextSize, x, y + nextSize);
            countConfetti(nextSize, x + nextSize, y);
            countConfetti(nextSize, x + nextSize, y + nextSize);
        }
    }

    private static boolean isAllSame(int n, int x, int y, int standardColor) {
        for (int nx = x; nx < x + n; nx++) {
            for (int ny = y; ny < y + n; ny++) {
                if (standardColor != map[nx][ny]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void baseCase(int n, int x, int y) {
        int tmpStandardColor = map[x][y];
        int tmpCountOfWhite = 0;
        int tmpCountOfBlue = 0;
        boolean isSame = true;
        for (int nx = x; nx < x + n; nx++) {
            for (int ny = y; ny < y + n; ny++) {
                int nowColor = map[nx][ny];
                if (tmpStandardColor != nowColor) {
                    isSame = false;
                }
                if (nowColor == WHITE) {
                    tmpCountOfWhite++;
                }
                else if (nowColor == BLUE) {
                    tmpCountOfBlue++;
                }
            }
        }
        if (isSame) {
            if (tmpStandardColor == WHITE) {
                countOfWhite++;
            }
            else if (tmpStandardColor == BLUE) {
                countOfBlue++;
            }
        }
        else {
            if (tmpStandardColor == WHITE) {
                countOfWhite += tmpCountOfWhite;
            }
            else if (tmpCountOfBlue == BLUE) {
                countOfBlue += tmpCountOfBlue;
            }
        }
    }
    
}