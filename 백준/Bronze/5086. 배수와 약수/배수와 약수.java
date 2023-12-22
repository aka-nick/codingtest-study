import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int[] numbers = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (numbers[0] == 0 && numbers[1] == 0) break;

            if (numbers[1] % numbers[0] == 0) {
                System.out.println("factor");
                continue;
            }
            if (numbers[0] % numbers[1] == 0) {
                System.out.println("multiple");
                continue;
            }
            System.out.println("neither");
        }
        br.close();
    }

}