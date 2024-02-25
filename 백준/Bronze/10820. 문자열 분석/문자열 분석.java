import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = br.readLine()) != null) {
            int[] counts = new int[4];
            line.chars()
                    .forEach(c -> {
                        if (Character.isLowerCase(c)) {
                            counts[0]++;
                        } else if (Character.isUpperCase(c)) {
                            counts[1]++;
                        } else if (Character.isDigit(c)) {
                            counts[2]++;
                        } else {
                            counts[3]++;
                        }
                    });
            result
                    .append(counts[0]).append(" ")
                    .append(counts[1]).append(" ")
                    .append(counts[2]).append(" ")
                    .append(counts[3]).append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}