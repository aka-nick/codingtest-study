import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rowLength = Integer.parseInt(st.nextToken());
        int colLength = Integer.parseInt(st.nextToken());
        List<String> board = new ArrayList<>();
        setBoard(br, rowLength, board);
        br.close();

        int minOfRecolor = Integer.MAX_VALUE;
        for (int startOfRow = 0; startOfRow <= rowLength - 8; startOfRow++) {
            for (int startOfCol = 0; startOfCol <= colLength - 8; startOfCol++) {
                minOfRecolor = Math.min(minOfRecolor, countOfRecoloring(board, startOfRow, startOfCol));
            }
        }

        System.out.println(minOfRecolor);
    }

    private static String[] baseStrings = {"WBWBWBWB", "BWBWBWBW"};
    private static int countOfRecoloring(List<String> board, int startOfRow, int startOfCol) {
        int countOfRecolor = 0;

        for (int idxOfRow = 0; idxOfRow < 8; idxOfRow++) {
            int rowPosition = startOfRow + idxOfRow;

            for (int idxOfCol = 0; idxOfCol < 8; idxOfCol++) {
                int colPosition = startOfCol + idxOfCol;

                char nowChar = board.get(rowPosition).charAt(colPosition);
                char baseChar = baseStrings[rowPosition % 2].charAt(idxOfCol);
                if (nowChar != baseChar) {
                    countOfRecolor++;
                }
            }
        }

        return Math.min(countOfRecolor, 64 - countOfRecolor);
    }

    private static void setBoard(BufferedReader br, int n, List<String> board) throws IOException {
        for (int i = 0; i < n; i++) {
            board.add(br.readLine());
        }
    }
}