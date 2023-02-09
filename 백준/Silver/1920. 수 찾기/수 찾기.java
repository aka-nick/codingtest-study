import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int m = Integer.parseInt(br.readLine());
        int[] f = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            f[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        result = new StringBuilder();
        for (int target : f) {
            int l = 0;
            int r = n - 1;

            while (l <= r) {
                int mid = (l + r) / 2;

                if (a[mid] == target) {
                    printAvailable();
                    break;
                }
                else if (a[mid] < target) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }


            }

            if (r < l) {
                printUnavailable();
            }
        }

        System.out.println(result);
    }

    private static void printUnavailable() {
        result.append(0).append(System.lineSeparator());
    }

    private static void printAvailable() {
        result.append(1).append(System.lineSeparator());
    }

}