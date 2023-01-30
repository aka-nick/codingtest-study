import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] mem = new int[n + 3];
            mem[1] = 1;
            mem[2] = 2;
            mem[3] = 4;
            for (int i = 4; i <= n; i++) {
                mem[i] = mem[i - 3] + mem[i - 2] + mem[i - 1];
            }

            System.out.println(mem[n]);
        }

        br.close();
    }
}