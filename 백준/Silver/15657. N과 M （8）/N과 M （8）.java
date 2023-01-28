import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static List<Integer> numbers;
    private static int[] selected;
    private static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.valueOf(st.nextToken()));
        }
        br.close();

        selected = new int[m];
        result = new StringBuilder();
        numbers.sort((o1, o2) -> o1 - o2);

        bt(0);

        System.out.println(result);
    }

    private static void bt(int depth) {
        if (depth == m) {
            for (int i : selected) {
                result.append(i).append(' ');
            }
            result.append(System.lineSeparator());
            return;
        }

        for (int i = 0; i < n; i++) {
            int number = numbers.get(i);
            if (0 < depth && number < selected[depth - 1]) {
                continue;
            }
            selected[depth] = number;
            bt(depth + 1);
        }
    }

}