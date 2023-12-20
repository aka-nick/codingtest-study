import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (n-->0) {
            result.append(br.readLine().toLowerCase()).append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}