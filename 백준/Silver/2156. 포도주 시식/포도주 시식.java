import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    f(1) => v(1)
    f(2) => f(1) + v(2)
    f(3) => Math.max( f(1), v(2) ) + v(3)
    f(n) => Math.max( Math.max( f(n - 2), v(n - 1) + f(n - 3) ) + v(n), f(n-1) )
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] v = new int[n + 4];
        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int[] mem = new int[n + 4];
        mem[1] = v[1];
        mem[2] = mem[1] + v[2];
        for (int i = 3; i <= n; i++) {
            mem[i] = Math.max(Math.max(mem[i - 2], v[i - 1] + mem[i - 3]) + v[i], mem[i - 1]);
        }

        System.out.println(mem[n]);
    }

}