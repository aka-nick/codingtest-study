import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        while (true) {
            String numbers = br.readLine();
            if ("0 0".equals(numbers)) {
                break;
            }

            result.append(Arrays.stream(numbers.split(" "))
                            .mapToInt(Integer::parseInt)
                            .sum())
                    .append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}