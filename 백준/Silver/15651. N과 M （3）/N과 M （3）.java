import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static boolean[] visited;
    private static int[] selected;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        selected = new int[m];
        br.close();

        method(0);

        System.out.println(result);
    }

    private static void method(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                result.append(selected[i]).append(' ');
            }
            result.append(System.lineSeparator());
            return;
        }

        for (int i = 1; i <= n; i++) {
//            if (!visited[i]) {
                selected[depth] = i;
//                visited[selected[depth]] = true;
                method(depth + 1);
//                visited[selected[depth]] = false;
                selected[depth] = 0;
//            }
        }
    }
}