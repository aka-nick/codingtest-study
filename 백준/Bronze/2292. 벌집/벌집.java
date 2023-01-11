import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int count = 1;
        int num = 2;
        while (num <= n) {
            num += 6 * count;
            count++;
        }

        System.out.println(count);
    }
}