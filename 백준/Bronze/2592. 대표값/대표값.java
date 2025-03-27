import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            int number = Integer.parseInt(br.readLine());
            sum += number;
            frequencies.put(
                    number,
                    frequencies.getOrDefault(number, 0) + 1
            );
        }
        br.close();

        System.out.println(sum / 10);
        System.out.println(frequencies.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .findFirst()
                .get()
                .getKey());
    }

}