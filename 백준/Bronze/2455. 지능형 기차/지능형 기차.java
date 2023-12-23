import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int[] persons = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            count -= persons[0];
            count += persons[1];

            max = Math.max(max, count);
        }
        br.close();

        System.out.println(max);
    }

}