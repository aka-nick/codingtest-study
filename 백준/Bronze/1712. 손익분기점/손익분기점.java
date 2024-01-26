import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] abc = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Integer::parseInt)
                .toArray();
        br.close();

        if (abc[2] - abc[1] <= 0) {
            System.out.println(-1);
            return;
        }

        System.out.println((abc[0] / (abc[2] - abc[1])) + 1);
    }

}