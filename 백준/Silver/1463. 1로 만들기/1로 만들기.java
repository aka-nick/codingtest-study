import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int count = dp(x, 0);

        System.out.println(count);
    }

    static int dp(int n, int cnt) {
        if (n < 2) {
            return cnt;
        }

        return Math.min(
                dp(n / 2, cnt + 1 + (n % 2)),
                dp(n / 3, cnt + 1 + (n % 3))
        );
    }

}