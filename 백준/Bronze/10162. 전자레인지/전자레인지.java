import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        br.close();

        int a = 300;
        int b = 60;
        int c = 10;
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        while (a <= t) {
            t -= a;
            aCount++;
        }
        while (b <= t) {
            t -= b;
            bCount++;
        }
        while (c <= t) {
            t -= c;
            cCount++;
        }

        if (t != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(aCount + " " + bCount + " " + cCount);
    }

}