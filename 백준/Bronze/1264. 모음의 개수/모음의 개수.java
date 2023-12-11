import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer result = new StringBuffer();
        while (true) {
            String sentence = br.readLine().toLowerCase();
            if ("#".equals(sentence)) {
                break;
            }

            result.append(sentence.chars()
                            .filter(c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                            .count())
                    .append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}