import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] kda = Arrays.stream(br.readLine().split("/"))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.close();

        if (kda[1] == 0 || kda[0] + kda[2] < kda[1]) {
            System.out.println("hasu");
            return;
        }
        System.out.println("gosu");
    }

}