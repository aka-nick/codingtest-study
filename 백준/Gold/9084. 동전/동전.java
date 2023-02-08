import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (t-- > 0) {
            run(br, result);
        }
        br.close();

        System.out.println(result);
    }

    private static void run(BufferedReader br, StringBuilder result) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        int[][] mem = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            mem[i][0] = 1;
        }

        for(int nowCoinIndex = 1; nowCoinIndex <= n; nowCoinIndex++) {
            int nowCoin = coins[nowCoinIndex];
            for(int targetAmount = 1; targetAmount <= m; targetAmount++) {
                int preCoinNowCaseCount = mem[nowCoinIndex - 1][targetAmount];
                int nowCoinPreCaseCount = targetAmount < nowCoin
                        ? 0 : mem[nowCoinIndex][targetAmount - nowCoin];

                mem[nowCoinIndex][targetAmount] = preCoinNowCaseCount + nowCoinPreCaseCount;
            }
        }

        result.append(mem[n][m]).append(System.lineSeparator());
    }
}