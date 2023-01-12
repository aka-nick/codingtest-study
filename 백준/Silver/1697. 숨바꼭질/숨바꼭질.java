import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        br.close();

        int time = -1;
        Deque<Integer> q = new ArrayDeque<>();
        Map<Integer, Long> visited = new HashMap<>();

        visit(n, n, visited);
        q.addLast(n);

        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            while (0 < size--) {
                int key = q.pollFirst();
                int route1 = -1;
                int route2 = -1;
                int route3 = -1;

                if (key == m) {
                    System.out.println(time);
                    return;
                }

                if (0 <= key - 1) {
                    route1 = key - 1;
                    nextStep(q, visited, key, route1);
                }
                if (key + 1 <= 100000) {
                    route2 = key + 1;
                    nextStep(q, visited, key, route2);
                }
                if (key != 0 && key * 2 <= 100000) {
                    route3 = key * 2;
                    nextStep(q, visited, key, route3);
                }
            }
        }


    }

    private static void nextStep(Deque<Integer> q,
            Map<Integer, Long> visited,
            int key,
            int route) {

        if (visited.getOrDefault(route, -1L) == -1L) {
            visit(route, route + visited.get(key), visited);
            q.addLast(route);
        }
    }

    private static void visit(int key, long value, Map<Integer, Long> visited) {
        visited.put(key, value);
    }

}