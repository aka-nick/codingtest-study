import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] abc = br.readLine().split(" ");
        int a = Integer.parseInt(abc[0]);
        int b = Integer.parseInt(abc[1]);
        int c = Integer.parseInt(abc[2]);
        br.close();

        System.out.println(divideMod(a, b, c));
    }

    private static long divideMod(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }

        long half = divideMod(a, b / 2, c);

        if (b % 2 == 0) {
            return half * half % c;
        }
        return (half * half % c) * a % c;
    }

}