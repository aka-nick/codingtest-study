import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[21];
        for (int i = 0; i < 21; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < 10; i++) {
            int[] range = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int distance = range[1] - range[0];
            for (int base = range[0]; base < (range[1] - range[0]) / 2 + range[0] + 1; base++) {
                int opposite = base + distance;

                int tmp = arr[base];
                arr[base] = arr[opposite];
                arr[opposite] = tmp;

                distance -= 2;

            }
        }
        br.close();

        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}