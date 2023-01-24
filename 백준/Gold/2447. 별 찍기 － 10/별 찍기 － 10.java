import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static char[][] canvas;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        canvas = new char[n][n];
        Arrays.stream(canvas).forEach(row -> Arrays.fill(row, ' '));

        recursivePrintStar(0, 0, n);

        StringBuilder result = new StringBuilder();
        for (char[] row : canvas) {
            for (char ch : row) {
                result.append(ch);
            }
            result.append(System.lineSeparator());
        }
        System.out.println(result);
    }

    private static void recursivePrintStar(int x, int y, int size) {
        if (size == 1) {
            canvas[x][y] = '*';
            return;
        }

        int blockSize = size / 3;
        for (int nx = 0; nx < 3; nx++) {
            for (int ny = 0; ny < 3; ny++) {
                if (nx == 1 && ny == 1) {
                    continue;
                }
                recursivePrintStar(nx * blockSize + x, ny * blockSize + y, blockSize);
            }
        }
    }


}