import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (n-->0) {
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                result.append("=");
            }
            result.append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}