import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int result = 0;
        int digits = 1;
        int up = 10;
        for (int i = 1; i <= n; i++) {
            if (i % up == 0) {
                digits++;
                up *= 10;
            }
            result += digits;
        }

        System.out.println(result);
    }

}