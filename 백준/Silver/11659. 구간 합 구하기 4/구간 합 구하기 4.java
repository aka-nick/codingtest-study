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
        int m = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = n - 1; 0 < i; i--) {
            numbers[i] += numbers[i + 1];
        }

        List<Range> cases = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            cases.add(new Range(Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken())));
        }

        br.close();

        StringBuilder result = new StringBuilder();
        for (Range range : cases) {
            result.append(numbers[range.start] - numbers[range.end + 1])
                    .append(System.lineSeparator());
        }
        System.out.println(result);
    }

    static class Range {
        int start;
        int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}