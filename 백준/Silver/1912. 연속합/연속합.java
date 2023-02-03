import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.valueOf(st.nextToken()));
        }
        br.close();

        int max = numbers.get(1);
        int[] mem = new int[n + 1];
        mem[0] = 0;
        for (int i = 1; i <= n; i++) {
            mem[i] = Math.max(mem[i - 1] + numbers.get(i), numbers.get(i));
            max = Math.max(mem[i], max);
        }

        System.out.println(max);

    }

}