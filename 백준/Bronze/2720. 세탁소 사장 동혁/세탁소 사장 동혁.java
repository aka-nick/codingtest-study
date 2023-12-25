import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        StringBuilder result = new StringBuilder();
        while (t-->0) {
            int price = Integer.parseInt(br.readLine());
            result.append(price / quarter).append(" ");
            price %= quarter;
            result.append(price / dime).append(" ");
            price %= dime;
            result.append(price / nickel).append(" ");
            price %= nickel;
            result.append(price).append(" ");
            result.append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}