import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if (isPrimeNumber(Integer.parseInt(st.nextToken()))) {
                result++;
            }
        }
        br.close();

        System.out.println(result);
    }

    static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        if (number != 2 && number % 2 == 0) {
            return false;
        }
        for (int i = 3; i < number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}