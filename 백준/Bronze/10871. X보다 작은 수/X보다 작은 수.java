import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        br.close();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (now < x) {
                result.append(now).append(" ");
            }
        }

        System.out.println(result);
    }
}