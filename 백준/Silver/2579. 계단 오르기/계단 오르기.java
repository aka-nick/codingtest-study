import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] v = new int[n + 3];
        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(br.readLine());
        }

        int[] f = new int[n + 3];
        setBaseCase(n, v, f);

        bottomUp(n, v, f);

        br.close();
        System.out.println(f[n]);
    }

    private static void bottomUp(int n, int[] v, int[] f) {
        for (int i = 3; i <= n; i++) {
            f[i] = Math.max(v[i - 1] + f[i - 3], f[i - 2]) + v[i];
        }
    }

    private static void setBaseCase(int n, int[] v, int[] f) {
        f[0] = 0;
        f[1] = v[1];

        if (2 <= n) {
            f[2] = v[1] + v[2];
        }
    }
    
}