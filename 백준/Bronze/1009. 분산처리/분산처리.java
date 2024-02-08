import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (t-- > 0) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            int number = 1;
            for (int i = 0; i < b; i++) {
                number *= a;
                number %= 10;
            }
            if (number == 0) {
                number = 10;
            }
            result.append(number).append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}