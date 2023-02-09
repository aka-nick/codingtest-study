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
        int[] weights = new int[n + 1];
        int[] values = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int[][] dp = new int[n + 1][k + 1]; // n번째 물건을 뽑을 차례가 되었으며 동시에 허용 중량이 k 일 때, 가질 수 있는 최대 가치.
        for (int i = 1; i <= n; i++) { // i: 현재 물건을 가리키는 순번
            for (int j = 1; j <= k; j++) { // j: 현재 허용하는 무게
                if (0 <= j - weights[i]) {
                    /*
                    코드 'dp[i - 1][j - weights[i]] + values[i]' 중 '[j - weights[i]]' 부분에 대한 설명
                    가방 안에 넣을 수 있는 물건의 조건 : 이전 물건의 중량 + 이번 물건의 중량 <= 이번 허용 중량
                                                    => 이전 물건의 중량 <= 이번 허용 중량 - 이번 물건의 중량
                                                    => 그런데 위 값의 최대치가 되는 경우: **이전 물건의 중량 == 이번 허용 중량 - 이번 물건의 중량**
                    설명 마지막 부분을 코드로 옮기면 위와 같은 코드가 된다.
                    결국 dp[i - 1(이전 물건의)][j - weights[i](최대로 확보할 수 있는 중량)]의 값(그 때의 최대 가치)을 구할 수 있기 때문에 Subproblem이 해결된 것이다.
                     */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}