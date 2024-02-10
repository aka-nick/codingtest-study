import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().split(" ")[1]);
        Integer nthScore = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf)
                .sorted(Comparator.reverseOrder())
                .skip(n - 1)
                .findFirst().orElse(-1);
        br.close();

        System.out.println(nthScore);
    }

}