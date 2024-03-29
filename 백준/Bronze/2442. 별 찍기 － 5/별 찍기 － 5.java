import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            result.append(" ".repeat(n - i));
            result.append("*".repeat(2 * i - 1));
            result.append(System.lineSeparator());
        }

        System.out.println(result);
    }

}