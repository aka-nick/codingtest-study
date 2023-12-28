import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();
        while (true) {
            int[] sides = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0) {
                break;
            }

            if (sides[0] + sides[1] <= sides[2]) {
                result.append("Invalid").append(System.lineSeparator());
            } else if (sides[0] == sides[1] && sides[1] == sides[2]) {
                result.append("Equilateral").append(System.lineSeparator());
            } else if (sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2]) {
                result.append("Isosceles").append(System.lineSeparator());
            } else {
                result.append("Scalene").append(System.lineSeparator());
            }
        }
        br.close();

        System.out.println(result);
    }

}