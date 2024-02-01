import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[5];
        for (int i = 0; i < 5; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int avg = Arrays.stream(input).sum() / 5;
        int mid = Arrays.stream(input)
                .sorted()
                .skip(2)
                .findFirst().getAsInt();

        System.out.println(avg);
        System.out.println(mid);
    }

}