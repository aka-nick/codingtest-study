import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);
        int[] temps = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.close();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += temps[i];
        }

        int max = sum;
        for (int i = k; i < n; i++) {
            sum = sum - temps[i - k] + temps[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

}