import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static List<Integer> numbers;
    private static int[] selected;
    private static StringBuilder result;
    private static boolean[] visited;
    private static Set<String> setForDuplicate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.valueOf(st.nextToken());
            numbers.add(number);
        }
        br.close();

        selected = new int[m];
        visited = new boolean[n];
        numbers.sort((o1, o2) -> o1 - o2);
        result = new StringBuilder();
        setForDuplicate = new HashSet<>();


        bt(0);

        System.out.println(result);
    }

    private static void bt(int depth) {
        if (depth == m) {
            StringBuilder tmp = new StringBuilder();
            for (int i : selected) {
                tmp.append(i).append(' ');
            }
            if (setForDuplicate.contains(tmp.toString())) {
                return;
            }
            setForDuplicate.add(tmp.toString());
            result.append(tmp).append(System.lineSeparator());
            return;
        }

        for (int i = 0; i < n; i++) {
            int number = numbers.get(i);
            if (!visited[i]) {
                selected[depth] = number;
                visited[i] = true;
                bt(depth + 1);
                visited[i] = false;
            }
        }
    }

}