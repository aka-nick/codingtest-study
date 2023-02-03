import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        long a = 1;
        long b = 1;
        for (int i = 3; i <= n; i++) {
            long tmp = a + b;
            a = b;
            b = tmp;
        }

        System.out.println(b);
    }

}