import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static int n;
    private static int m;
    private static char dasom;
    private static char[][] map;
    private static boolean[][] visited;
    private static int count = 0;
    private static Position[] selected;
    private static Set<String> setForDuplicate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = 5;
        m = 7;
        dasom = 'S';
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = chars[j];
            }
        }
        br.close();

        visited = new boolean[n][n];
        selected = new Position[m];
        setForDuplicate = new HashSet<>();

        bt(0);

        System.out.println(count);
    }

    private static void bt(int depth) {
        if (depth == m) {
            // 카운트 처리 S가 4이상이면 카운트
            //  하지만 중복건은 들어가지 않도록
            int tmpCount = 0;
            for (Position pos : selected) {
                if (map[pos.x][pos.y] == dasom) tmpCount++;
            }
            if (4 <= tmpCount) {
                StringBuilder tmp = new StringBuilder();
                Arrays.stream(selected)
                        .sorted((o1, o2) -> o1.x == o2.x ? o1.y - o2.y : o1.x - o2.x)
                        .forEach(o -> tmp.append(o.x)
                                .append(',')
                                .append(o.y)
                                .append(System.lineSeparator()));
                if (!setForDuplicate.contains(tmp.toString())) {
                    setForDuplicate.add(tmp.toString());
                    count++;
                }
            }
            return;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {

                    // 1 <= depth이면,
                    //  새 위치가 이전 요소들 전부와 비교하여 인접한 위치인지 확인
                    //      인접하지 않았으면 return;이 아니라 continue;
                    if (1 <= depth) {
                        boolean isSide = false;
                        for (int s = 0; s < selected.length; s++) {
                            Position pos = selected[s];
                            if (null == pos) break;
                            if (Math.abs(pos.x - i) == 1 && Math.abs(pos.y - j) == 0 ||
                                    Math.abs(pos.x - i) == 0 && Math.abs(pos.y - j) == 1) {
                                isSide = true;
                                break;
                            }
                        }
                        if (!isSide) {
                            continue;
                        }
                    }

                    // 중복 없이 방문해나갈 수 있도록 함
                    visited[i][j] = true;
                    selected[depth] = new Position(i, j);
                    bt(depth + 1);
                    selected[depth] = null;
                    visited[i][j] = false;
                }
            }
        }
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}