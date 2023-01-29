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
    private static boolean[] visited;
    private static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if ("0".equals(s.trim())) break;

            StringTokenizer st = new StringTokenizer(s);
            while (st.hasMoreTokens()) {
                n = Integer.parseInt(st.nextToken());
                m = 6;
                numbers = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    numbers.add(Integer.parseInt(st.nextToken()));
                }
                numbers.sort((o1, o2) -> o1 - o2);
                selected = new int[m];
                visited = new boolean[n];

                bt(0);
                result.append(System.lineSeparator());
            }
        }
        br.close();

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
            if (0 < depth && number < selected[depth - 1]) continue;

            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = number;
                bt(depth + 1);
                selected[depth] = 0;
                visited[i] = false;
            }
        }
    }
    
}