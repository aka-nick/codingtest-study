import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(getMultiMod(a, b, c));
    }

    private static long getMultiMod(int a, int b, int c) {
        if (b == 1) return a % c;

        long sub = getMultiMod(a, b / 2, c);
        return b % 2 == 0 ? sub * sub % c : (sub * sub % c) * a % c;
    }

}