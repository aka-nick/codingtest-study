import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] adjacent = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            adjacent[vertex1][vertex2] = 1;
            adjacent[vertex2][vertex1] = 1;
        }
        br.close();

        int days = 1;
        StringBuilder pairByDate = new StringBuilder();

        int totalNumberOfPairs = m;
        int numberOfPairsUntilYesterday;

        while (totalNumberOfPairs < ((n * n - n) / 2)) {
            numberOfPairsUntilYesterday = totalNumberOfPairs;
            days++;

            for (int nowVertex = 1; nowVertex <= n; nowVertex++) {
                for (int friendVertex = 1; friendVertex <= n; friendVertex++) {

                    if (0 < adjacent[nowVertex][friendVertex]
                            && adjacent[nowVertex][friendVertex] < days
                            && nowVertex != friendVertex) {

                        for (int subFriendVertex = 1; subFriendVertex <= n; subFriendVertex++) {
                            if (0 < adjacent[friendVertex][subFriendVertex]
                                    && adjacent[friendVertex][subFriendVertex] < days
                                    && nowVertex != subFriendVertex) {

                                if (adjacent[nowVertex][subFriendVertex] == 0) {
                                    adjacent[nowVertex][subFriendVertex] = days;
                                    adjacent[subFriendVertex][nowVertex] = days;
                                    totalNumberOfPairs += 1;
                                }
                            }
                        }
                    }
                }
            }

            pairByDate.append(totalNumberOfPairs - numberOfPairsUntilYesterday)
                    .append(System.lineSeparator());
        }

        System.out.println(--days); // 첫날 제외
        System.out.println(pairByDate.toString());
    }

}