import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] sums = new int[n + 1];
        sums[1] = numbers[0];
        for (int i = 2; i <= n; i++) {
            sums[i] = sums[i - 1] + numbers[i - 1];
        }

        StringBuilder result = new StringBuilder();
        while (m-- > 0) {
            String[] ijLine = br.readLine().split(" ");
            int i = Integer.parseInt(ijLine[0]);
            int j = Integer.parseInt(ijLine[1]);
            result.append(sums[j] - sums[i - 1])
                    .append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}