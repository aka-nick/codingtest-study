import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] names = br.readLine().split("-");
        br.close();

        StringBuilder result = new StringBuilder();
        for (String name : names) {
            char c = name.charAt(0);
            result.append(c);
        }

        System.out.println(result);
    }

}