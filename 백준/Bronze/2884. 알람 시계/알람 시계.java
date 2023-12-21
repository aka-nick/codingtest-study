import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] hm = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.close();

        int h = hm[0];
        int m = hm[1];

        if (45 <= m) {
            m -= 45;
        }
        else {
            m = 60 - (45 - m);

            if (h == 0) {
                h = 23;
            } else {
                h--;
            }
        }

        System.out.println(h + " " + m);
    }

}