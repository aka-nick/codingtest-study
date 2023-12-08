import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main      {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cheapestBurger = Integer.MAX_VALUE;
        int cheapestBeverage = Integer.MAX_VALUE;
        int n = 3;
        while (n-- > 0) {
            cheapestBurger = Math.min(
                    cheapestBurger,
                    Integer.parseInt(br.readLine()));
        }

        n = 2;
        while (n-- > 0) {
            cheapestBeverage = Math.min(
                    cheapestBeverage,
                    Integer.parseInt(br.readLine()));
        }

        System.out.println(cheapestBeverage + cheapestBurger - 50);
    }

}