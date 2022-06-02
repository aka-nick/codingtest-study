import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coinSize = sc.nextInt();
        int amount = sc.nextInt();
        sc.nextLine();
        int[] coins = new int[coinSize];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.valueOf(sc.nextLine());
        }
        sc.close();

        long[] bottomup = new long[amount + 1];
        bottomup[0] = 1L;

        for (int i = 0; i < coins.length ; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i]) {
                    bottomup[j] += bottomup[j - coins[i]];
                }
            }
        }

        System.out.println(bottomup[amount]);
    }
    
}