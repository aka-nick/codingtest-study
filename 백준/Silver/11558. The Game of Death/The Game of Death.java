import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[][] adjacent;
    static boolean[] visited;
    static int n;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine()); // 정점 정보 초기화

            // 인접행렬 초기화
            adjacent = new boolean[n + 1][n + 1];

            // 방문배열 초기화
            visited = new boolean[n + 1];

            // 인접정보 입력
            for (int j = 1; j <= n; j++) {
                int dest = Integer.parseInt(br.readLine());
                adjacent[j][dest] = true;

            }
            bfs(); // 탐색
        }

        System.out.println(result.toString()); // 탐색 결과 한 번에 출력
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited[1] = true;

        boolean isFound = false;
        int count = 0;
        search:
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (0 < size--) {
                int start = queue.poll();

                if (start == n) {
                    isFound = true;
                    break search;
                }

                for (int dest = 1; dest <= n; dest++) {
                    if (adjacent[start][dest] && !visited[dest]) {
                        visited[dest] = true;
                        queue.add(dest);
                    }
                }
            }

            count++;
        }

        int resultsBySearch = isFound ? count : 0;
        result.append(resultsBySearch).append(System.lineSeparator());
    }

}