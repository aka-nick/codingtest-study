import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.IntSummaryStatistics;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        br.close();

        IntSummaryStatistics summaryStatistics = IntStream.rangeClosed(1, n)
                .map(number -> number * number)
                .filter(number -> m <= number && number <= n)
                .summaryStatistics();

        if (summaryStatistics.getCount() == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getMin());
    }

}