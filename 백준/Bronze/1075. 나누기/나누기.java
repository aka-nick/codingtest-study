import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());
        br.close();
        int forward = n / 100 * 100;

        for (int minNum = 0; minNum < 100; minNum++) {
            int now = forward + minNum;
            if (now % f == 0) {
                if (minNum < 10) {
                    System.out.println("0" + minNum);
                } else {
                    System.out.println(minNum);
                }
                return;
            }
        }

    }

}