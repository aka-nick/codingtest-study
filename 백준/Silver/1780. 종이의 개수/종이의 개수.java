import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static int nPaperCount = 0; // -1
    private static int zPaperCount = 0; // 0
    private static int pPaperCount = 0; // 1
    private static final int N = -1;
    private static final int Z = 0;
    private static final int P = 1;

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

        paper(n, 0, 0);

        System.out.println(nPaperCount);
        System.out.println(zPaperCount);
        System.out.println(pPaperCount);
    }

    // 주어진 n 크기의 종이(x ~ x+n, y ~ y+n)가 모두 동일한 무늬(숫자)인지 확인하여,
    //     같은 숫자면 해당 숫자의 종이를 1 센 뒤 리턴하고
    //     다른 숫자면 n/3의 크기로 나누어 같은 작업을 반복
    private static void paper(int n, int x, int y) {

        if (n == 3) {
            baseCase(n, x, y);
            return;
        }

        int standard = map[x][y];
        boolean isAllSame = isAllSame(n, x, y, standard);
        if (isAllSame) {
            if (standard == N) nPaperCount++;
            else if (standard == Z) zPaperCount++;
            else if (standard == P) pPaperCount++;
            return;
        }

        int nn = n / 3;
        for (int i = 0; i < n; i += nn) {
            for (int j = 0; j < n; j += nn) {
                paper(nn, x + i, y + j);
            }
        }
    }

    private static void baseCase(int n, int x, int y) {
        int standard = map[x][y];
        boolean isSame = true;
        int nTmpCount = 0;
        int zTmpCount = 0;
        int pTmpCount = 0;

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (map[i][j] == N) nTmpCount++;
                else if (map[i][j] == Z) zTmpCount++;
                else if (map[i][j] == P) pTmpCount++;

                if (standard != map[i][j]) {
                    isSame = false;
                }
            }
        }

        if (isSame) {
            if (standard == N) nPaperCount++;
            else if (standard == Z) zPaperCount++;
            else if (standard == P) pPaperCount++;
        }
        else {
            nPaperCount += nTmpCount;
            zPaperCount += zTmpCount;
            pPaperCount += pTmpCount;
        }
    }

    private static boolean isAllSame(int n, int x, int y, int standard) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (standard != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}