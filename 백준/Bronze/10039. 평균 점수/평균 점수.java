import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 5;
        List<Integer> scores = new ArrayList<>();
        while (n-- > 0) {
            scores.add(Integer.valueOf(br.readLine()));
        }
        br.close();

        int average = (int) scores.stream()
                .mapToInt(score -> {
                    if (score < 40) {
                        return 40;
                    }
                    return score;
                })
                .average().getAsDouble();

        System.out.println(average);
    }

}