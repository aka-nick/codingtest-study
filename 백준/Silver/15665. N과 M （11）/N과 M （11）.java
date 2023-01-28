import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    private static int n;
    private static int m;
    private static List<Integer> numbers;
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

        numbers = numbers.stream().distinct().sorted().collect(Collectors.toList());
        selected = new int[m];
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

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            selected[depth] = number;
            bt(depth + 1);
        }
    }

}