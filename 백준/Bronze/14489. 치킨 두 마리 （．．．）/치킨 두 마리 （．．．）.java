import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int c = Integer.parseInt(br.readLine());
        br.close();

        int a = arr[0];
        int b = arr[1];

        System.out.println((a + b < c * 2) ? (a + b) : (a + b - (c * 2)));
    }

}