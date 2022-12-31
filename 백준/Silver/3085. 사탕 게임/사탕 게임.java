import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final char RED = 'C';
    private static final char BLUE = 'P';
    private static final char GREEN = 'Z';
    private static final char YELLOW = 'Y';
    private static final int RED_NUMBER = 0;
    private static final int BLUE_NUMBER = 1;
    private static final int GREEN_NUMBER = 2;
    private static final int YELLOW_NUMBER = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] candies = new char[n][n];
        setCandies(br, n, candies);
        br.close();

//        int[] largestInRow = new int[n];
//        int[] largestInColumn = new int[n];
//        setLargestInRow(n, candies, largestInRow);
//        setLargestInColumn(n, candies, largestInColumn);

        int maxCandy = 0;
        // 가로로 옮기고(컬럼을 스왑하고), 가로 중 가장 큰 개수 얻기(로우 중 가장 큰 수 얻기)
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n - 1; col++) {
                swapColumnInRow(candies, col, row); // 옮기고
                maxCandy = Integer.max(maxCandy, getMaxCandyInLine(n, candies, row, true));
                maxCandy = Integer.max(maxCandy, getMaxCandyInLine(n, candies, col, false));
                maxCandy = Integer.max(maxCandy, getMaxCandyInLine(n, candies, col + 1, false));
                swapColumnInRow(candies, col, row); // 다음 스왑을 위해서 다시 제자리로 옮겨둔다
            }
        }
        // 세로로도 똑같이 한다
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n - 1; row++) {
                swapRowInColumn(candies, col, row);
                maxCandy = Integer.max(maxCandy, getMaxCandyInLine(n, candies, row, true));
                maxCandy = Integer.max(maxCandy, getMaxCandyInLine(n, candies, row + 1, true));
                maxCandy = Integer.max(maxCandy, getMaxCandyInLine(n, candies, col, false));
                swapRowInColumn(candies, col, row);
            }
        }

        System.out.println(maxCandy);
    }

    private static void swapRowInColumn(char[][] candies, int col, int row) {
        char tmp = candies[row][col];
        candies[row][col] = candies[row + 1][col];
        candies[row + 1][col] = tmp;
    }

    private static void swapColumnInRow(char[][] candies, int col, int row) {
        char tmp = candies[row][col];
        candies[row][col] = candies[row][col + 1];
        candies[row][col + 1] = tmp;
    }

    private static int getMaxCandyInLine(int n, char[][] candies, int lineNumber, boolean isRow) {
        int[][] line = new int[n][4];

        char beforeCandy = ' ';
        int countRed = 0;
        int countBlue = 0;
        int countGreen = 0;
        int countYellow = 0;
        for (int i = 0; i < n; i++) {

            char nowCandy = candies[lineNumber][i];
            if (!isRow) {
                nowCandy = candies[i][lineNumber];
            }

            if (i == 0) {
                accumulateCandyInLine(line, i, nowCandy, 1);
                beforeCandy = nowCandy;
                continue;
            }

            if (beforeCandy != nowCandy) {
                accumulateCandyInLine(line, i, nowCandy, 1);
                beforeCandy = nowCandy;
            }
            else {
                int updateValue = line[i - 1][getColorNumber(nowCandy)] + 1;
                accumulateCandyInLine(line, i, nowCandy, updateValue);
            }

        }
        for (int i = 0; i < n; i++) {
            countRed = Integer.max(line[i][0], countRed);
            countBlue = Integer.max(line[i][1], countBlue);
            countGreen = Integer.max(line[i][2], countGreen);
            countYellow = Integer.max(line[i][3], countYellow);
        }

        int maxCandy = getMaxCandy(countRed, countBlue, countGreen, countYellow);
        return maxCandy;
    }
    private static final int getColorNumber(char color) {
        if (color == RED) {
            return RED_NUMBER;
        }
        else if (color == BLUE) {
            return BLUE_NUMBER;
        }
        else if (color == GREEN) {
            return GREEN_NUMBER;
        } else {
            return YELLOW_NUMBER;
        }
    }

    private static int getMaxCandy(int countRed, int countBlue, int countGreen, int countYellow) {
        return Integer.max(
                Integer.max(
                        Integer.max(countRed, countBlue),
                        countGreen),
                countYellow);
    }

    private static void accumulateCandyInLine(int[][] line, int i, char nowCandy, int value) {
        if (nowCandy == RED) {
            line[i][0] = value;
        } else if (nowCandy == BLUE) {
            line[i][1] = value;
        } else if (nowCandy == GREEN) {
            line[i][2] = value;
        } else if (nowCandy == YELLOW) {
            line[i][3] = value;
        }
    }

    private static void setCandies(BufferedReader br, int n, char[][] candies) throws IOException {
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                candies[i][j] = s.charAt(j);
            }
        }
    }

}