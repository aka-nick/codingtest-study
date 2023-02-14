import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String t;
    private static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        System.out.println(f(t) == true ? 1 : 0);

        br.close();
    }

    private static boolean f(String str) {
        if (str.length() == s.length()) {
            return s.equals(str);
        }

        boolean result1 = false;

        if (str.charAt(str.length() - 1) == 'A') {
            result1 = f(str.substring(0, str.length() - 1));
        }

        boolean result2 = false;
        if (str.charAt(0) == 'B') {
            result2 = f(new StringBuilder(str.substring(1)).reverse().toString());
        }

        return result1 || result2;
    }

}