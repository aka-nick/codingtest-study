import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        while (true) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("#")) break;

            result.append(input[0]);
            if (17 < Integer.parseInt(input[1])
                    || 80 <= Integer.parseInt(input[2])) {
                result.append(" Senior").append(System.lineSeparator());
            }
            else {
                result.append(" Junior").append(System.lineSeparator());
            }
        }
        br.close();

        System.out.println(result);
    }

}