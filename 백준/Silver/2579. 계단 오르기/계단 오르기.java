import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] stairs;
    static Integer[] mem;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stairs = new int[n + 1];
        mem = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        mem[0] = stairs[0];
        mem[1] = stairs[1];
        if (2 <= n) {
            mem[2] = stairs[2] + stairs[1];
        }

        System.out.println(f(n));
    }

    static int f(int n) {

        if (mem[n] == null) {
            mem[n] = Math.max(
                    f(n - 3) + stairs[n - 1],
                    f(n - 2)
            ) + stairs[n];
        }

        return mem[n];
    }
}