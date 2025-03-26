import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ox = br.readLine().split(" ");
        br.close();

        int total = 0;
        int add = 0;
        for (int i = 0; i < ox.length; i++) {
            if ("0".equals(ox[i])) {
                add = 0;
            } else {
                add++;
                total += add;
            }
        }

        System.out.println(total);
    }

}