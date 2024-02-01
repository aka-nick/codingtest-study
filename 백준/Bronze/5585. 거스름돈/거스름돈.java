import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int remain = 1000 - Integer.parseInt(br.readLine());
        br.close();

        int count = 0;
        int idx = 5;
        int[] change = new int[6];
        change[5] = 500;
        change[4] = 100;
        change[3] = 50;
        change[2] = 10;
        change[1] = 5;
        change[0] = 1;

        while (0 <= idx) {
            if (change[idx] <= remain) {
                remain -= change[idx];
                count++;
                continue;
            }
            idx--;
        }

        System.out.println(count);
    }

}