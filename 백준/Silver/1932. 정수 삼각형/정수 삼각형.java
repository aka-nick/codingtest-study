import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] v = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(v[i], -1);
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = 0;
            while (st.hasMoreTokens()) {
                v[i][k++] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int[][] dp = new int[n][n];
        dp[0][0] = v[0][0];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + v[i + 1][j]); //down-left
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + v[i + 1][j + 1]); //down-right
            }
        }

        int result = -1;
        for (int i : dp[n - 1]) {
            result = Math.max(result, i);
        }

        System.out.println(result);
    }
}