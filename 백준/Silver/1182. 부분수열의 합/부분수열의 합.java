import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int count = 0;
    private static int[] arr;
    private static int n;
    private static int s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        summation(0, 0);

        if (s == 0) {
            count--;
        }

        System.out.println(count);
    }

    private static void summation(int idx, int sum) {
        if (idx == n) {
            if (sum == s) {
                count++;
            }
            return;
        }

        summation(idx + 1, sum + arr[idx]);
        summation(idx + 1, sum);
    }

}