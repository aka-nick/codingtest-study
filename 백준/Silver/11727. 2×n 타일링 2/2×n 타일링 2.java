import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int[] mem = new int[n + 1];
        mem[0] = 0;
        mem[1] = 1;
        if (1 < n) mem[2] = 3;

        for (int i = 3; i <= n; i++) {
            mem[i] = ((mem[i - 1] % 10007) + ((mem[i - 2] * 2) % 10007)) % 10007 ;
        }

        System.out.println(mem[n]);
    }

}