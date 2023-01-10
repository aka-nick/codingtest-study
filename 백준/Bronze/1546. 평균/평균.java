import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Long> scores = new ArrayList<>();
        double max = 0;
        for (int i = 0; i < n; i++) {
            long score = Long.parseLong(st.nextToken());
            max = Math.max(max, score);
            scores.add(score);
        }
        br.close();

        double sum = 0;
        for (int i = 0; i < scores.size(); i++) {
            sum += scores.get(i) / max * 100;
        }

        System.out.println(sum / scores.size());

    }
}