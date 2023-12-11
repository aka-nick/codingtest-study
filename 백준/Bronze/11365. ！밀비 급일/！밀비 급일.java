import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        while (true) {
            String sentence = br.readLine();
            if ("END".equals(sentence)) {
                break;
            }

            result.append(new StringBuilder(sentence).reverse())
                    .append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}