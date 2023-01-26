import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder result = new StringBuilder();
    static int[] selectNumbers;
    static int n;
    static int m;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selectNumbers = new int[m + 1];
        visited = new boolean[n + 1];
        br.close();

        bt(0);

        System.out.println(result);
    }

    private static void bt(int countOfSelected) {
        if (countOfSelected == m) {
            for (int i = 0; i < m; i++) {
                result.append(selectNumbers[i]).append(' ');
            }
            result.append(System.lineSeparator());
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                selectNumbers[countOfSelected] = i;
                visited[i] = true;
                bt(countOfSelected + 1);
                visited[i] = false;
            }
        }
    }
    
}