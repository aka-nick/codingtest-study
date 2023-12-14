import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] names = { "Soongsil", "Korea", "Hanyang" };
        int[] scores = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.close();
        String minName = names[IntStream.range(0, 3)
                .filter(i -> scores[i] == Arrays.stream(scores).min().getAsInt())
                .findFirst()
                .getAsInt()];

        if (Arrays.stream(scores).sum() < 100) {
            System.out.println(minName);
            return;
        }
        System.out.println("OK");
    }

}