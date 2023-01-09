import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> numbers = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        br.close();

        Deque<Integer> deq1 = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deq1.addLast(i);
        }
        Deque<Integer> deq2 = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deq2.addLast(i);
        }

        int interval = 0;
        while (0 < m--) {
            int targetNumber = numbers.remove(0);

            int interval1 = 0;
            while (deq1.getFirst() != targetNumber) {
                deq1.addLast(deq1.pollFirst());
                interval1++;
            }
            deq1.removeFirst();

            int interval2 = 0;
            while (deq2.getFirst() != targetNumber) {
                deq2.addFirst(deq2.pollLast());
                interval2++;
            }
            deq2.removeFirst();

            interval += Math.min(interval1, interval2);
        }

        System.out.println(interval);
    }
    
}