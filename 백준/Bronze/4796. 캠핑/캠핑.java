import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int days = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (l == 0 && p == 0 && v == 0) break;

            int total = 0;

            total += (v / p) * l;
            if (v % p < l) {
                total += v % p;
            }
            else {
                total += l;
            }

            sb.append(String.format("Case %d: %d", days++, total)).append(System.lineSeparator());
        }
        br.close();

        System.out.println(sb.toString());
    }
}