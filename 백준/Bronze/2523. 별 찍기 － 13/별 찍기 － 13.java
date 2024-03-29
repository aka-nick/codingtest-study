import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 1; i <= n; i++) {
            System.out.println("*".repeat(i));
        }
        for (int i = n - 1; 0 < i; i--) {
            System.out.println("*".repeat(i));
        }
    }

}