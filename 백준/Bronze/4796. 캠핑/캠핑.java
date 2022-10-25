import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        calculateCampingDays();
    }

    private static void calculateCampingDays() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int numberOfCase = 1;
        while (true) {
            String readLine = br.readLine();

            if (isItOver(new StringTokenizer(readLine))) break;

            result.append(String.format("Case %d: %d", numberOfCase++, getTotalDays(new StringTokenizer(readLine))))
                    .append(System.lineSeparator());
        }

        br.close();
        System.out.println(result);
    }

    private static boolean isItOver(StringTokenizer st) {

        boolean result = false;

        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        if (l == 0 && p == 0 && v == 0) {
            result = true;
        }

        return result;
    }

    private static int getTotalDays(StringTokenizer st) {

        int result = 0;

        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        result += (v / p) * l;
        if (v % p < l) {
            result += v % p;
        }
        else {
            result += l;
        }

        return result;
    }

}
