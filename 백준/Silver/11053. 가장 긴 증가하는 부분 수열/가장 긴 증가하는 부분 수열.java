import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int[] mem = new int[n];
        mem[0] = 1;
        for (int i = 1; i < n; i++) {
            int idx = i;
            int maxIdx = i;
            while (idx-- > 0) {
                if (a[idx] < a[i]) {
                    if (mem[maxIdx] < mem[idx]) {
                        maxIdx = idx;
                    }
                }
            }
            mem[i] = 1;
            if (maxIdx != i) {
                mem[i] = mem[maxIdx] + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(mem[i], max);
        }
        System.out.println(max);
    }
}