import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] mods = new Integer[42];
        for (int i = 0; i < 10; i++) {
            mods[Integer.parseInt(br.readLine()) % 42] = 1;
        }
        br.close();

        int diff = 0;
        for (Integer mod : mods) {
            if (mod != null) {
                diff++;
            }
        }

        System.out.println(diff);
    }

}