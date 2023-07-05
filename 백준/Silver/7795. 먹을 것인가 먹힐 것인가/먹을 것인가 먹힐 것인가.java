import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        while (t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Integer[] a = new Integer[n];
            Integer[] b = new Integer[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a, Comparator.comparingInt(i -> -i));
            Arrays.sort(b, Comparator.comparingInt(i -> -i));

            int result = 0;
            int passed = 0;
            for (int i = 0; i < n; i++) {
                if (m - passed == 0) break;
                if (a[i] <= b[passed]) {
                    passed++;
                    i--;
                    continue;
                }
                result += m - passed;
            }
            output.append(result).append(System.lineSeparator());
        }
        br.close();
        System.out.println(output);
    }
}