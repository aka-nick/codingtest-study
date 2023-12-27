import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seq = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= 5; i++) {
            int sum = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sum();
            if (max < sum) {
                max = sum;
                seq = i;
            }
        }
        br.close();

        System.out.println(seq + " " + max);
    }

}