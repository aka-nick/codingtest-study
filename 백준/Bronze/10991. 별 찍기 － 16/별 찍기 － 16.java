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
            int term = n - i;
            result.append(" ".repeat(term));
            for (int j = 0; j < i; j++) {
                result.append("*").append(" ");
            }
            result.append(System.lineSeparator());
        }

        System.out.println(result);
    }

}