import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Deque<Integer> d = new ArrayDeque<>();
        while (k-- > 0) {
            int now = Integer.parseInt(br.readLine());
            if (now == 0) {
                d.pop();
                continue;
            }
            d.push(now);
        }
        br.close();

        long sum = d.stream()
                .mapToLong(Integer::longValue)
                .sum();

        System.out.println(sum);
    }

}