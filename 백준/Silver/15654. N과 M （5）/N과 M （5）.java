import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[] selected;
    private static boolean[] visited;
    private static List<Integer> list;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int max = -1;
        for (int i = 0; i < n; i++) {
            int nowNumber = Integer.valueOf(st.nextToken());
            list.add(nowNumber);
            max = Math.max(max, nowNumber);
        }
        br.close();

        list.sort((o1, o2) -> o1 - o2);
        selected = new int[m];
        visited = new boolean[max + 1];

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
            int number = list.get(i);
            if (!visited[number]) {
                selected[depth] = number;
                visited[number] = true;
                bt(depth + 1);
                visited[number] = false;

            }

        }
    }

}