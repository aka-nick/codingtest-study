import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().split(" ")[0]);
        StringBuilder result = new StringBuilder();
        while (n-- > 0) {
            result.append(new StringBuilder(br.readLine()).reverse())
                    .append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}