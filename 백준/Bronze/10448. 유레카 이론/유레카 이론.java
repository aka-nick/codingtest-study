import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int MAX_TRINUMBERS_IDX = 46;
    private static final int[] TRINUMBERS = new int[MAX_TRINUMBERS_IDX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        setNumbers(br, n, numbers);
        br.close();
        setTriNumbers();

        StringBuilder result = new StringBuilder();
        for (Integer number : numbers) {
            checkForExactThreeTrinumbers(number, result);
        }

        System.out.print(result);
    }

    private static void checkForExactThreeTrinumbers(int n, StringBuilder result) {
        for (int i = 1; i < MAX_TRINUMBERS_IDX; i++) {
            for (int j = 1; j < MAX_TRINUMBERS_IDX; j++) {
                for (int k = 1; k < MAX_TRINUMBERS_IDX; k++) {
                    int sum = TRINUMBERS[i] + TRINUMBERS[j] + TRINUMBERS[k];
                    if (sum == n) {
                        result.append(1).append(System.lineSeparator());
                        return;
                    }
                }
            }
        }
        result.append(0).append(System.lineSeparator());
    }

    private static void setTriNumbers() {
        for (int i = 1; i < MAX_TRINUMBERS_IDX; i++) {
            TRINUMBERS[i] = TRINUMBERS[i - 1] + i;
        }
    }

    private static void setNumbers(BufferedReader br, int n, List<Integer> numbers)
            throws IOException {
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }
    }
}