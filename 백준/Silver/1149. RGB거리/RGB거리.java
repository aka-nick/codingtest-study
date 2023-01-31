import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Cost> costs = new ArrayList<>();
        costs.add(new Cost(0, 0, 0));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs.add(new Cost(Integer.valueOf(st.nextToken()),
                    Integer.valueOf(st.nextToken()),
                    Integer.valueOf(st.nextToken())));
        }
        br.close();

        int[][] f = new int[n + 3][3];
        f[0][RED] = 0;
        f[0][GREEN] = 0;
        f[0][BLUE] = 0;
        f[1][RED] = costs.get(1).r;
        f[1][GREEN] = costs.get(1).g;
        f[1][BLUE] = costs.get(1).b;
        for (int k = 2; k <= n; k++) {
            f[k][RED] = Math.min(f[k - 1][GREEN], f[k - 1][BLUE]) + costs.get(k).r;
            f[k][GREEN] = Math.min(f[k - 1][RED], f[k - 1][BLUE]) + costs.get(k).g;
            f[k][BLUE] = Math.min(f[k - 1][RED], f[k - 1][GREEN]) + costs.get(k).b;
        }

        System.out.println(Math.min(f[n][RED], Math.min(f[n][GREEN], f[n][BLUE])));
    }

    static class Cost {
        int r;
        int g;
        int b;

        public Cost(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }
    
}