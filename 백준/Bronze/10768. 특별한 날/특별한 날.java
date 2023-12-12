import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(br.readLine());
        int date = Integer.parseInt(br.readLine());
        br.close();

        if (month == 2 && date == 18) {
            System.out.println("Special");
            return;
        }

        if (month < 2 || month == 2 && date < 18) {
            System.out.println("Before");
            return;
        }

        System.out.println("After");
    }

}