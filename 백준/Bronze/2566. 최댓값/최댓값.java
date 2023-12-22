import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String result = "";
        for (int i = 0; i < 9; i++) {
            result += br.readLine() + " ";
        }
        br.close();

        int[] numbers = Arrays.stream(result.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = Arrays.stream(numbers)
                .max().getAsInt();
        System.out.println(max);

        int idx = -1;
        for (int i = 0; i < 81; i++) {
            if (numbers[i] == max) {
                idx = i;
                break;
            }
        }

        System.out.println((idx / 9 + 1) + " " + (idx % 9 + 1));

    }

}