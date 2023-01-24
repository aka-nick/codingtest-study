import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> numbers = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int numCard = Integer.parseInt(st.nextToken());
            numbers.put(numCard, numbers.getOrDefault(numCard, 0) + 1);
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        br.close();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            result.append(numbers.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(' ');
        }

        System.out.println(result);
    }

}