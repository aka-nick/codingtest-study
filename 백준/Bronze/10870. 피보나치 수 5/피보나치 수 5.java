import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int[] fibos = new int[21];
        fibos[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibos[i] = fibos[i - 1] + fibos[i - 2];
        }

        System.out.println(fibos[n]);
    }

}