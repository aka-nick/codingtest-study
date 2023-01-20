import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if ("0 0 0".equals(str.trim())) {
                break;
            }

            StringTokenizer st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int tmp = Math.max(a, b);
            a = Math.min(a, b);
            b = tmp;
            tmp = Math.max(b, c);
            b = Math.min(b, c);
            c = tmp;

            if ((a*a) + (b*b) == c*c) {
                result.append("right");
            }
            else {
                result.append("wrong");
            }
            result.append(System.lineSeparator());
        }
        br.close();

        System.out.println(result);
    }

}