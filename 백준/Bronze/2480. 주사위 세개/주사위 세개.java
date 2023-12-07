import java.io.*;
import java.util.stream.*;
import java.util.*;
import java.util.Map.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> dices = new HashMap<>();
        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(dice -> dices.put(dice, dices.getOrDefault(dice, 0) + 1));
        br.close();

        Entry<Integer, Integer> result = dices.entrySet().stream()
                .sorted((d1, d2) -> {
                    if (d1.getValue() != d2.getValue()) {
                        return d2.getValue() - d1.getValue();
                    }
                    return d2.getKey() - d1.getKey();
                })
                .limit(1)
                .findFirst().get();

        System.out.println(calcPrize(result));

    }

    private static int calcPrize(Entry<Integer, Integer> result) {
        if (result.getValue() == 3) {
            return 10_000 + (result.getKey() * 1_000);
        }
        if (result.getValue() == 2) {
            return 1_000 + (result.getKey() * 100);
        }
        return result.getKey() * 100;
    }

}