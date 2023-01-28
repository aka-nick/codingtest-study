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
    private static boolean[] visited;
    private static int[] selected;
    private static Set<String> setForDuplicate;
    private static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.valueOf(st.nextToken()));
        }
        br.close();

        numbers.sort((o1, o2) -> o1 - o2);
        selected = new int[m];
        visited = new boolean[n];
        setForDuplicate = new HashSet<>();
        result = new StringBuilder();

        bt(0);

        System.out.println(result);
    }

    private static void bt(int depth) {
        if (depth == m) {
            StringBuilder tmp = new StringBuilder();
            for (int i : selected) {
                tmp.append(i).append(' ');
            }
            if (setForDuplicate.contains(tmp.toString())) return;

            setForDuplicate.add(tmp.toString());
            result.append(tmp).append(System.lineSeparator());
            return;
        }

        for (int i = 0; i < n; i++) {
            int number = numbers.get(i);
            if (0 < depth && number < selected[depth - 1] ) {
                continue;
            }
            if (visited[i]){
                continue;
            }
            selected[depth] = number;
            visited[i] = true;
            bt(depth + 1);
            visited[i] = false;
        }
    }

}