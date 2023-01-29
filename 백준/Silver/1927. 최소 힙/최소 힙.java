import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    private static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }
        br.close();

        result = new StringBuilder();
        queueing(numbers);

        System.out.println(result);
    }

    private static void queueing(List<Integer> numbers) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer number : numbers) {
            if (number == 0) {
                int addValue = pq.isEmpty() ?
                        0 : pq.poll();
                result.append(addValue).append(System.lineSeparator());
                continue;
            }

            pq.add(number);
        }
    }

}