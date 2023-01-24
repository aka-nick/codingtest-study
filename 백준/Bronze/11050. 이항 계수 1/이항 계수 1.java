import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        int[] factorials = new int[i + 1];
        factorials[0] = 1;
        factorials[1] = 1;
        br.close();
        for (int k = 2; k <= i; k++) {
            factorials[k] = factorials[k - 1] * k;
        }

        System.out.println(factorials[i] / (factorials[i - j] * factorials[j]));
    }

}