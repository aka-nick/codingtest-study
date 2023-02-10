import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int l;
    private static int c;
    private static StringBuilder result;
    private static char[] selected;
    private static char[] candidates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        candidates = new char[c];
        for (int i = 0; i < c; i++) {
            candidates[i] = st.nextToken().toCharArray()[0];
        }
        Arrays.sort(candidates);

        selected = new char[l];
        result = new StringBuilder();
        pwCreate(0);

        System.out.println(result);
        br.close();
    }

    private static void pwCreate(int depth) {
        if (depth == l) {
            StringBuilder tmp = new StringBuilder();
            List<Character> moList = List.of('a', 'e', 'i', 'o', 'u');
            int moCnt = 0;
            for (char c : selected) {
                if (moList.contains(c)) moCnt++;
                tmp.append(c);
            }
            int jaCnt = l - moCnt;
            if (1 <= moCnt && 2 <= jaCnt) {
                result.append(tmp).append(System.lineSeparator());
            }
            return;
        }

        for (int i = depth; i < c; i++) {
            char candidate = candidates[i];
            if (0 < depth && candidate <= selected[depth - 1]) {
                continue;
            }
            selected[depth] = candidate;
            pwCreate(depth + 1);
        }
    }
}