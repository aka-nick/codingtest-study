import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            long countOfBae = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .filter(number -> number == 0)
                    .count();

            if (countOfBae == 1) {
                result.append("A").append(System.lineSeparator());
            } else if (countOfBae == 2) {
                result.append("B").append(System.lineSeparator());
            } else if (countOfBae == 3) {
                result.append("C").append(System.lineSeparator());
            } else if (countOfBae == 4) {
                result.append("D").append(System.lineSeparator());
            } else {
                result.append("E").append(System.lineSeparator());
            }

        }
        br.close();

        System.out.println(result);
    }

}