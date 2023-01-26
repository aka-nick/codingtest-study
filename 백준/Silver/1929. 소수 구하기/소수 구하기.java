import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        br.close();

        numbers = new boolean[n + 1];
        Arrays.fill(numbers, true);
        numbers[0] = false;
        numbers[1] = false;

        erts(n);

        StringBuilder result = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (numbers[i]) {
                result.append(i).append(System.lineSeparator());
            }
        }

        System.out.println(result);
    }

    private static void erts(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (!numbers[i]) {
                continue;
            }

            for (int j = i + i; j <= n; j += i) {
                numbers[j] = false;
            }
        }
    }

}