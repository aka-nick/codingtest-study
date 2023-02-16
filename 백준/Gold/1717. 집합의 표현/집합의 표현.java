import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[] sets;
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 원소로 주어지는 수 0~n (n+1개)
        int m = Integer.parseInt(st.nextToken()); // 연산의 개수
        List<StringTokenizer> commands = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            commands.add(new StringTokenizer(br.readLine()));
        }
        br.close();

        sets = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            sets[i] = i;
        }

        StringBuilder result = new StringBuilder();
        for (StringTokenizer command : commands) {
            boolean isJoinCommand = command.nextToken().equals("0") ? true : false;
            int a = Integer.parseInt(command.nextToken());
            int b = Integer.parseInt(command.nextToken());

            if (isJoinCommand) {
                union(a, b);
            }
            else {
                result.append(checkJoined(a, b) ? YES : NO).append(System.lineSeparator());
            }
        }

        System.out.println(result);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        sets[pa] = pb;
    }
    private static int find(int x) {
        if (x == sets[x]) {
            return x;
        }
        else {
            return sets[x] = find(sets[x]);
        }
    }
    private static boolean checkJoined(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        return pa == pb;
    }
}