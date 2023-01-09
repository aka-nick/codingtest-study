import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] steels = br.readLine().toCharArray();
        br.close();

        int sum = 0;
        int stick = 0;
        for (int i = 0; i < steels.length; i++) {
            char now = steels[i];

            if (now == OPEN) {
                stick++;
            }
            else { // now == CLOSE
                stick--;
                if (isLaserPoint(steels[i - 1])) {
                    sum += stick;
                }
                else {
                    sum += 1;
                }
            }
        }

        System.out.println(sum);
    }

    private static boolean isLaserPoint(char before) {
        return before == OPEN;
    }
}