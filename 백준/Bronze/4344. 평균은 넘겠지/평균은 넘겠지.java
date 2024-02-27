import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (c-- > 0) {
            String[] line = br.readLine().split(" ");
            IntSummaryStatistics summaryStatistics = Arrays.stream(line)
                    .skip(1)
                    .mapToInt(Integer::parseInt)
                    .summaryStatistics();

            long total = summaryStatistics.getCount();
            double average = summaryStatistics.getAverage();
            int count = 0;
            for (int i = 1; i < line.length; i++) {
                int score = Integer.parseInt(line[i]);
                if (average < score) {
                    count++;
                }
            }

            BigDecimal formatted = new BigDecimal((double) count / (double) total * 100)
                    .setScale(3, RoundingMode.HALF_UP);
            
            result
                    .append(formatted)
                    .append("%")
                    .append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}