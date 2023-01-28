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
        br.close();

        visited = new boolean[n + 1];
        selected = new int[m];

        bt(0);

        System.out.println(result);
    }

    private static void bt(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                result.append(selected[i]).append(' ');
            }
            result.append(System.lineSeparator());
            return;
        }


        for (int i = 1; i <= n; i++) {
            if (0 < depth && i < selected[depth - 1]) {
                continue;
            }

            selected[depth] = i;
            bt(depth + 1);
        }
    }

}