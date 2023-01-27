import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int[][] cases = new int[n + 1][k + 1];
        Arrays.stream(cases).forEach(row -> row[0] = 1);

        for (int coinIdx = 1; coinIdx < n + 1; coinIdx++) {
            for (int price = 1; price < k + 1; price++) {

                if (0 <= price - coins[coinIdx]) {
                    int prePriceCaseCount = cases[coinIdx][price - coins[coinIdx]];
                    int preCoinCaseCount = cases[coinIdx - 1][price];
                    cases[coinIdx][price] = prePriceCaseCount + preCoinCaseCount;
                }
                else {
                    cases[coinIdx][price] = cases[coinIdx - 1][price];
                }
            }
        }

        System.out.println(cases[n][k]);
    }

}