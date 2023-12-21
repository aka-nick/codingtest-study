import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int s = n - i;

            result.append(" ".repeat(i))
                    .append("*".repeat(s))
                    .append(System.lineSeparator());
        }

        System.out.println(result);
    }

}