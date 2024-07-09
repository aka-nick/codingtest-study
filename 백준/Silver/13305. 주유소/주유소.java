import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> mileages = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        List<Integer> prices = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        br.close();

        long sum = 0;
        int lastIdx = 0;
        for (int idx = 0; idx < mileages.size(); idx++) {
            if (prices.get(idx) < prices.get(lastIdx)) {
                lastIdx = idx;
            }
            sum += (long) prices.get(lastIdx) * mileages.get(idx);
        }

        System.out.println(sum);
    }
}