import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static char[][] CANVAS;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        CANVAS = new char[n][2 * n - 1];
        Arrays.stream(CANVAS).forEach(row -> Arrays.fill(row, ' '));
        star(0, n - 1, n);

        StringBuilder result = new StringBuilder();
        for (char[] row : CANVAS) {
            for (char c : row) {
                result.append(c);
            }
            result.append(System.lineSeparator());
        }

        System.out.println(result);
    }

    private static void star(int x, int y, int n) {
        if (n == 3) {
            CANVAS[x][y] = '*';
            CANVAS[x + 1][y - 1] = CANVAS[x + 1][y + 1] = '*';
            CANVAS[x + 2][y - 2] = CANVAS[x + 2][y - 1] = CANVAS[x + 2][y] =
                    CANVAS[x + 2][y + 1] = CANVAS[x + 2][y + 2] = '*';
            return;
        }

        int half = n / 2;
        star(x, y, half);
        star(x + half, y - half, half);
        star(x + half, y + half, half);
    }
    
}