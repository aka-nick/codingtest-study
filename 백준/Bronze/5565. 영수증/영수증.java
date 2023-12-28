import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int other = br.lines()
                .limit(9)
                .mapToInt(Integer::parseInt)
                .sum();
        br.close();
        System.out.println(total - other);
    }

}