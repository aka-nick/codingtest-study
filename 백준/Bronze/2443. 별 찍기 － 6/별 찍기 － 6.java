import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 0; i < n; i++) {
            System.out.println(
                    " ".repeat(i) + "*".repeat(2 * (n - i) - 1));
        }
    }

}