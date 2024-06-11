import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.close();

        int[] results = new int[n];
        results[n - 1] = -1;
        Deque<Integer> d = new ArrayDeque<>();
        d.push(0);
        for (int i = 1; i < n; i++) {
            while (!d.isEmpty() && numbers[d.peek()] < numbers[i]) {
                results[d.pop()] = numbers[i];
            }
            d.push(i);
        }

        for (Integer i : d) {
            results[i] = -1;
        }

        System.out.println(IntStream.of(results)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

}