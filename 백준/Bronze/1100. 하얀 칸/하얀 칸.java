import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        for (int row = 0; row < 8; row++) {
            String line = br.readLine();
            for (int col = 0; col < 8; col++) {
                if (row % 2 == 0) {
                    if (col % 2 == 0) {
                        if (line.charAt(col) == 'F') {
                            count++;
                        }
                    }
                }
                if (row % 2 != 0) {
                    if (col % 2 != 0) {
                        if (line.charAt(col) == 'F') {
                            count++;
                        }
                    }
                }
            }
        }
        br.close();
        System.out.println(count);
    }

}