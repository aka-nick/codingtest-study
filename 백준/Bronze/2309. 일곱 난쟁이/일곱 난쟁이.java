import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            heights.add(Integer.valueOf(br.readLine()));
        }
        br.close();

        int sum = heights.stream().mapToInt(Integer::intValue).sum();
        int diff = sum - 100;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i <= j) continue;
                if (heights.get(i) + heights.get(j) == diff) {
                    heights.remove(i);
                    heights.remove(j);
                    heights.stream()
                            .sorted()
                            .forEach(System.out::println);
                    return;
                }
            }
        }
    }

}