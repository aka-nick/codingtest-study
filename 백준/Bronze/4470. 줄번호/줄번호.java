import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            result.append(i).append(". ").append(br.readLine()).append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}