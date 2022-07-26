import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Integer>[] adjacent = new List[n + 1];
        Arrays.setAll(adjacent, i -> new LinkedList<>());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjacent[s].add(e);
            adjacent[e].add(s);
        }
        br.close();

        int count = 0;
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        dq.push(1);
        visited[1] = true;

        while (!dq.isEmpty()) {
            Integer vertex = dq.pollLast();

            for (Integer next: adjacent[vertex]) {
                if (!visited[next]) {
                    dq.push(next);
                    visited[next] = true;
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}