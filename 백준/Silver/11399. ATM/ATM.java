import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] pi = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pi[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(pi);
        int sum = 0;
        for (int queueNumber = 0; queueNumber < pi.length; queueNumber++) {
            int nowSum = 0;
            for (int i = 0; i <= queueNumber; i++) {
                nowSum += pi[i];
            }
            sum += nowSum;
        }

        System.out.println(sum);
    }
}