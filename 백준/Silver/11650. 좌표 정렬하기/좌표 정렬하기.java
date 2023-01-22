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
        List<Coordinate> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Coordinate(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
        br.close();

        StringBuilder result = new StringBuilder();
        list.stream()
                .sorted((o1, o2) -> o1.x == o2.x
                        ? o1.y - o2.y : o1.x - o2.x)
                .forEach(o -> result.append(o.x)
                        .append(' ')
                        .append(o.y)
                        .append(System.lineSeparator()));

        System.out.println(result);
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}