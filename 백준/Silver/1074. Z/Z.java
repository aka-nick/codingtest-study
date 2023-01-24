import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        br.close();

        System.out.println(zTracking(n, r, c));
    }

    private static int zTracking(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int halfLength = 1 << (n - 1);
        int quarter = halfLength * halfLength;

        if (r < halfLength && c < halfLength) {
            return zTracking(n - 1, r, c);
        }
        if (r < halfLength && halfLength <= c) {
            return quarter + zTracking(n - 1, r, c - halfLength);
        }
        if (halfLength <= r && c < halfLength) {
            return 2 * quarter + zTracking(n - 1, r - halfLength, c);
        }
        return 3 * quarter + zTracking(n - 1, r - halfLength, c - halfLength);
    }
    
}