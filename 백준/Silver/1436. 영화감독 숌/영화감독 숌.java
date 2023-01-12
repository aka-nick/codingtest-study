import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        String findNumber = "666";
        int result = 0;
        int target = 665;
        while (0 < n) {
            target += 1;
            if (String.valueOf(target).contains(findNumber)) {
                n--;
                result = target;
            }
        }

        System.out.println(result);
    }

}