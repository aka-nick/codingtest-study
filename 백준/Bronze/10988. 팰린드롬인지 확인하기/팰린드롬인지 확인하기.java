import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();
        br.close();

        for (int idx = 0; idx < word.length / 2; idx++) {
            int xdi = word.length - idx - 1;

            if (word[idx] != word[xdi]) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }

}