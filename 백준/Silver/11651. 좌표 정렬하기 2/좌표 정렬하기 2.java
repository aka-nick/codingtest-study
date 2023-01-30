import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        StringBuilder result = new StringBuilder();
        list.stream()
                .sorted((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1])
                .forEach(o -> result.append(o[0])
                        .append(' ')
                        .append(o[1])
                        .append(System.lineSeparator()));

        System.out.println(result);
    }

}