import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = getReverseNum(st.nextToken());
        int num2 = getReverseNum(st.nextToken());
        br.close();

        System.out.println(Math.max(num1, num2));
    }

    private static int getReverseNum(String s) {
        return Integer.parseInt(
                new StringBuilder().append(s.charAt(2)).append(s.charAt(1)).append(s.charAt(0)).toString());
    }
}