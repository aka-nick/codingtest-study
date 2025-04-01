import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int[][] d = new int[n + 1][3];
        d[1][1] = s[1];
        for (int i = 2; i <= n; i++) {
            d[i][1] = Math.max(d[i - 2][1], d[i - 2][2]) + s[i];
            d[i][2] = d[i - 1][1] + s[i];
        }

        System.out.println(Math.max(d[n][1], d[n][2]));
    }

}
