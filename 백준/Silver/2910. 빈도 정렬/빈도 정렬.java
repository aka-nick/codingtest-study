import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nc = br.readLine().split(" ");
        int n = Integer.parseInt(nc[0]);
        int c = Integer.parseInt(nc[1]);
        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, Integer> appearance = new HashMap<>();
        String[] numbers = br.readLine().split(" ");
        for (int idx = 0; idx < n; idx++) {
            int nowNumber = Integer.parseInt(numbers[idx]);
            frequency.put(nowNumber, frequency.getOrDefault(nowNumber, 0) + 1);
            if (!appearance.containsKey(nowNumber)) {
                appearance.put(nowNumber, idx);
            }
        }
        br.close();

        StringBuilder result = new StringBuilder();
        frequency.entrySet().stream()
                .sorted((e1, e2) -> !e2.getValue().equals(e1.getValue())
                        ? e2.getValue() - e1.getValue()
                        : appearance.get(e1.getKey()) - appearance.get(e2.getKey()))
                .forEach(e -> {
                    for (int i = 0; i < e.getValue(); i++) {
                        result.append(e.getKey())
                                .append(' ');
                    }
                });

        System.out.println(result);
    }

}