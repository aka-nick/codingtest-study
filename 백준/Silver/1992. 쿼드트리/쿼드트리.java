import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    private static int[][] map;
    private static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = chars[j] - '0';
            }
        }
        br.close();

        compress(0, 0, n);

        System.out.println(result);
    }

    private static void compress(int x, int y, int size) {
        boolean isCompressible = true;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[x][y] != map[i][j]) {
                    isCompressible = false;
                }
            }
        }

        if (isCompressible) {
            result.append(map[x][y]);
            return;
        }

        result.append('(');
        compress(x, y, size / 2);
        compress(x, y + size / 2, size / 2);
        compress(x + size / 2, y, size / 2);
        compress(x + size / 2, y + size / 2, size / 2);
        result.append(')');
    }

}