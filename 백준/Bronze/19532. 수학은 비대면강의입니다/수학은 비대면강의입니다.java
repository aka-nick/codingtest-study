import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private static int a;
    private static int b;
    private static int c;
    private static int d;
    private static int e;
    private static int f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        Pair pair = IntStream.rangeClosed(-999, 999)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(-999, 999)
                        .mapToObj(j -> new Pair(i, j)))
                .filter(p -> a * p.x + b * p.y == c 
                        && d * p.x + e * p.y == f)
                .findFirst().orElseThrow();

        System.out.println(pair);
    }
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

    }

}