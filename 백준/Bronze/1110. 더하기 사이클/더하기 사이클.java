import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int org = n;
        br.close();

        int cycle = 0;
        while (true) {
            cycle++;
            n = cycling(n);
            if (n == org) break;
        }

        System.out.println(cycle);
    }

    private static int cycling(int n) {
        String tmp = "" + n;
        if (tmp.length() == 1) {
            tmp = "0" + tmp;
        }

        int left = tmp.charAt(0) - '0';
        int right = tmp.charAt(1) - '0';
        String sum = "" + (left + right);
        int last = sum.charAt(sum.length() - 1) - '0';

        return right * 10 + last;
    }

}