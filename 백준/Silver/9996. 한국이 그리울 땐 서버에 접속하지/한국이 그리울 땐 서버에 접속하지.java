import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().replace("*", " ").split(" ");
        StringBuilder result = new StringBuilder();
        while (n-->0) {
            String ex = br.readLine();
            result
                    .append(ex.startsWith(line[0])
                            && ex.endsWith(line[1])
                            && (line[0].length() + line[1].length()) <= ex.length() ? "DA" : "NE")
                    .append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}