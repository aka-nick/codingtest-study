import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.valueOf(st.nextToken()));
        }
        br.close();

        int[] mem1 = new int[n];
        mem1[0] = 1;
        for (int i = 0; i < n; i++) {
            int idx = i;
            int maxIdx = i;
            while (idx-- > 0) {
                if (numbers.get(idx) < numbers.get(i) &&
                        mem1[maxIdx] < mem1[idx]) {
                    maxIdx = idx;
                    mem1[i] = mem1[maxIdx] + 1;
                }
            }
            if (mem1[i] == 0) {
                mem1[i] = 1;
            }
        }

        int max = -1;
        int[] mem2 = new int[n];
        mem2[n - 1] = 1;
        for (int i = n - 1; 0 <= i; i--) {
            int idx = i;
            int maxIdx = i;
            while (++idx < n) {
                if (numbers.get(idx) < numbers.get(i) &&
                    mem2[maxIdx] < mem2[idx]) {
                    maxIdx = idx;
                    mem2[i] = mem2[maxIdx] + 1;
                }
            }
            if (mem2[i] == 0) {
                mem2[i] = 1;
            }

            max = Math.max(mem1[i] + mem2[i], max);
        }

        System.out.println(max - 1);
    }

}