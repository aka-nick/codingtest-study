import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] cables = new long[k];
        for (int i = 0; i < k; i++) {
            cables[i] = Long.parseLong(br.readLine());
        }
        br.close();
        Arrays.sort(cables);

        long r = cables[cables.length - 1] + 1; // 중간값이 0이 되지 않도록 최대값의 최소값이 1이 되게끔 한다.
        long l = 0;
        while (l < r) {
            long m = (r + l) / 2;

            int count = 0;
            for (long cable : cables) {
                count += cable / m;
            }

            if (n <= count) {
                l = m + 1;
            }
            else {
                r = m;
            }
        }

        System.out.println(l - 1);
    }

}