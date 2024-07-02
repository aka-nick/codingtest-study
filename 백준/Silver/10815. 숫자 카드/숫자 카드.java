import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cards = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int m = Integer.parseInt(br.readLine());
        String result = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .mapToObj(quiz -> 0 <= Arrays.binarySearch(cards, quiz) ? "1" : "0")
                .collect(Collectors.joining(" "));
        br.close();

        System.out.println(result);
    }

}
