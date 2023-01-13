import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseNumber = Integer.parseInt(br.readLine());
        List<Integer> ls = new ArrayList<>();
        List<int[]> nows = new ArrayList<>();
        List<int[]> dests = new ArrayList<>();
        for (int i = 0; i < testcaseNumber; i++) {
            ls.add(Integer.parseInt(br.readLine()));
            StringTokenizer st = new StringTokenizer(br.readLine());
            nows.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            st = new StringTokenizer(br.readLine());
            dests.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        br.close();

        StringBuilder result = new StringBuilder();
        testcase:
        for (int i = 0; i < ls.size(); i++) {
            int l = ls.get(i);
            int[] now = nows.get(i);
            int[] dest = dests.get(i);
            int[][] map = new int[l][l];
            if (now[0] == dest[0] && now[1] == dest[1]) {
                result.append(0).append(System.lineSeparator());
                continue;
            }

            map[dest[0]][dest[1]] = 1;
            int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
            int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
            Deque<int[]> q = new ArrayDeque<>();

            q.addLast(new int[]{now[0], now[1]});
            map[now[0]][now[1]] = -1;


            int step = -1;
            while (!q.isEmpty()) {
                int size = q.size();
                step++;

                while (size-- > 0) {
                    int[] pos = q.pollFirst();
                    for (int j = 0; j < 8; j++) {
                        int nx = pos[0] + dx[j];
                        int ny = pos[1] + dy[j];

                        if (nx < 0 || ny < 0 || l <= nx || l <= ny) {
                            continue;
                        }
                        if (map[nx][ny] == -1) {
                            continue;
                        }

                        if (map[nx][ny] == 1) {
                            result.append(++step).append(System.lineSeparator());
                            continue testcase;
                        }

                        q.addLast(new int[]{nx, ny});
                        map[nx][ny] = -1;
                    }
                }
            }
        }

        System.out.println(result);
    }

}