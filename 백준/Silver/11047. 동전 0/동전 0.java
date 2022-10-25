import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.valueOf(br.readLine()));
        }
        br.close();

        int result = 0;
        for (int i = list.size() - 1; 0 <= i; i--) {
            Integer nowToken = list.get(i);

            result += k / nowToken;
            k = k % nowToken;
        }

        System.out.println(result);
    }

}
