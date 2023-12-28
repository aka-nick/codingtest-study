import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {

            if (i == 1) {
                result.append(" ".repeat(n - i));
                result.append("*").append(System.lineSeparator());
                continue;
            }
            if (i == n) {
                result.append("*".repeat(n * 2 - 1)).append(System.lineSeparator());
                continue;
            }

            result
                    .append(" ".repeat(n - i))
                    .append("*")
                    .append(" ".repeat((i - 1) * 2 - 1))
                    .append("*")
                    .append(System.lineSeparator());
        }

        System.out.println(result);
    }

}