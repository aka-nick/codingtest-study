import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = setHeights(br);
        int total = getTotal(heights);
        br.close();

        findForgers(heights, total);

        System.out.println(getSeven(heights));
    }

    private static StringBuilder getSeven(int[] heights) {
        StringBuilder seven = new StringBuilder();
        Arrays.sort(heights);
        for (int i = 2; i < 9; i++) {
            seven.append(heights[i]).append(System.lineSeparator());
        }
        return seven;
    }

    private static int getTotal(int[] heights) {
        int total = 0;
        for (int i = 0; i < 9; i++) {
            total += heights[i];
        }
        return total;
    }

    private static int[] setHeights(BufferedReader br) throws IOException {
        int[] heights = new int[9];
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
        return heights;
    }

    private static void findForgers(int[] heights, int total) {
        int diff = total - 100;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (heights[i] + heights[j] == diff) {
                    heights[i] = -1;
                    heights[j] = -1;
                    return;
                }
            }
        }
    }

}