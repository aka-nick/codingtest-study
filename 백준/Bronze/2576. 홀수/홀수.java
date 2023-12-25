import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            numbers.add(Integer.valueOf(br.readLine()));
        }
        br.close();

        IntSummaryStatistics summary = numbers.stream()
                .filter(number -> number % 2 == 1)
                .mapToInt(i -> i)
                .summaryStatistics();

        if (summary.getSum() == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(summary.getSum());
        System.out.println(summary.getMin());

    }

}