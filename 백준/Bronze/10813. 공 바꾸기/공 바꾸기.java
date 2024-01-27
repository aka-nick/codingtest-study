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
        for (int i = 1; i <= n; i++) {
            baskets[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int[] replaces = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int tmp = baskets[replaces[0]];
            baskets[replaces[0]] = baskets[replaces[1]];
            baskets[replaces[1]] = tmp;
        }
        br.close();

        for (int i = 1; i <= n; i++) {
            System.out.print(baskets[i] + " ");
        }

    }

}