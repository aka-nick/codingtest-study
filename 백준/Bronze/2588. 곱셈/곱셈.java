import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int[] b = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.close();

        int c = a * b[2];
        int d = a * b[1];
        int e = a * b[0];

        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(c + (d * 10) + (e * 100));
    }

}