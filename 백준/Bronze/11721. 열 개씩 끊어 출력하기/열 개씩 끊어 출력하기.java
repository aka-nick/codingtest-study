import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        char[] chars = br.readLine().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result.append(chars[i]);
            if ((i + 1) % 10 == 0) {
                result.append(System.lineSeparator());
            }
        }
        br.close();

        System.out.println(result);
    }

}