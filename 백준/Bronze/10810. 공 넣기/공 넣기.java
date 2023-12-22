import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] baskets = new int[n + 1];
        while (m-->0) {
            int[] ball = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int i = ball[0]; i <= ball[1]; i++) {
                baskets[i] = ball[2];
            }
        }
        br.close();

        for (int i = 1; i < baskets.length; i++) {
            System.out.print(baskets[i] + " ");
        }
    }

}