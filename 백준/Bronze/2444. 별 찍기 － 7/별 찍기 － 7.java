import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 0; i < n; i++) {
            System.out.println(
                    " ".repeat(n - i - 1) + "*".repeat(2 * (i + 1) - 1));
        }

        for (int i = n - 1; 0 < i; i--) {
            System.out.println(
                    " ".repeat(n - i) + "*".repeat(2 * i - 1));
        }
    }

}