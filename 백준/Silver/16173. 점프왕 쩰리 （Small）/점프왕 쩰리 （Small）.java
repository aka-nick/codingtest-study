import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        String result = "Hing";
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int nowJump = map[xy[0]][xy[1]];

            if (nowJump == 0)
                continue;
            if (xy[0] == n - 1 && xy[1] == n - 1) {
                result = "HaruHaru";
                break;
            }

            if (xy[0] + nowJump < n) {
                queue.add(new int[]{xy[0] + nowJump, xy[1]});
            }
            if (xy[1] + nowJump < n) {
                queue.add(new int[]{xy[0], xy[1] + nowJump});
            }
        }

        System.out.println(result);
    }

}