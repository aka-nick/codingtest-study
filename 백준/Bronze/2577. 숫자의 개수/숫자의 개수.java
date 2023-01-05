import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int calc = a * b * c;
        br.close();

        int[] freq = new int[10];
        while (0 < calc) {
            freq[calc - calc / 10 * 10]++;
            calc /= 10;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            result.append(freq[i]).append(System.lineSeparator());
        }

        System.out.println(result);
    }
}