import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] prices = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] cars = new int[101];
        for (int i = 0; i < 3; i++) {
            int[] startEnd = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int time = startEnd[0]; time < startEnd[1]; time++) {
                cars[time]++;
            }
        }
        br.close();

        System.out.println(Arrays.stream(cars)
                .filter(car -> 0 < car)
                .map(car -> car * prices[car - 1])
                .sum());
    }

}