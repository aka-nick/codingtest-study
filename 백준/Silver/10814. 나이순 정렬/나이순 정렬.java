import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<OnlineJudgeMember> members = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            members.add(new OnlineJudgeMember(i, Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        br.close();

        StringBuilder result = new StringBuilder();
        members.stream()
                .sorted((o1, o2) -> o1.age != o2.age
                        ? o1.age - o2.age : o1.idx - o2.idx)
                .forEach(o -> result.append(o.age)
                        .append(' ')
                        .append(o.name)
                        .append(System.lineSeparator()));

        System.out.println(result);
    }

    static class OnlineJudgeMember {
        int idx;
        int age;
        String name;

        public OnlineJudgeMember(int idx, int age, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }
    }

}