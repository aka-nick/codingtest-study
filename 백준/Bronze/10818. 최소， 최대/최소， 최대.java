import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            max = Math.max(max, now);
            min = Math.min(min, now);
        }
        System.out.println(min + " " + max);
    }

}