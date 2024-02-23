import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder chunk = new StringBuilder();
        for (int i = 1; i <= n * 2; i++) {
            if (n % 2 == 0) {
                if (i <= n) {
                    if (i % 2 != 0) {
                        chunk.append("*");
                    } else {
                        chunk.append(" ");
                    }
                } else {
                    if (i % 2 != 0) {
                        chunk.append(" ");
                    } else {
                        chunk.append("*");
                    }
                }
            } else {
                if (i <= n) {
                    if (i % 2 != 0) {
                        chunk.append("*");
                    } else {
                        chunk.append(" ");
                    }
                } else {
                    if (i % 2 == 0) {
                        chunk.append(" ");
                    } else {
                        chunk.append("*");
                    }
                }
            }

            if (i == n) {
                chunk.append(System.lineSeparator());
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(chunk).append(System.lineSeparator());
        }

        System.out.println(result);
    }

}