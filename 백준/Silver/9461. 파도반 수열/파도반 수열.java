import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Integer> ns = new ArrayList<>();
        int max = -1;
        for (int i = 0; i < t; i++) {
            int n = Integer.valueOf(br.readLine());
            ns.add(n);
            max = Math.max(max, n);
        }
        br.close();

        long[] mem = new long[max + 7];
        mem[1] = 1;
        mem[2] = 1;
        mem[3] = 1;
        mem[4] = 2;
        mem[5] = 2;
        mem[6] = 3;
        mem[7] = 4;
        for (int i = 8; i <= max; i++) {
            mem[i] = mem[i - 1] + mem[i - 5];
        }

        StringBuilder result = new StringBuilder();
        for (Integer n : ns) {
            result.append(mem[n]).append(System.lineSeparator());
        }
        System.out.println(result);
    }

}