import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int maxDepth = 0;
        int answerSenior = 0;
        boolean[] visited;
        for (int i = 1; i <= n; i++) {
            int depth = 0;
            visited = new boolean[n + 1];

            int now = i;
            while (!visited[now]) {
                depth++;
                visited[now] = true;
                now = arr[now];
            }

            if (maxDepth < depth) {
                maxDepth = depth;
                answerSenior = i;
            }
        }

        System.out.println(answerSenior);
    }

}
