import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] mineMap = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                mineMap[i][j] = chars[j] == '*';
            }
        }
        boolean[][] openMap = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                openMap[i][j] = chars[j] == 'x';
            }
        }
        br.close();

        int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
        int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};
        boolean[][] visitedOpen = new boolean[n][n];
        Deque<int[]> q = new ArrayDeque<>();
        // openMap을 전부 훑는다
        // 현재 열린곳이 지뢰가 없으면,
        //  현재 열린곳의 팔방을 돌아서 지뢰 개수를 세고, 현재 자리(countMap[x][y])에 입력
        // 현재 열린 곳이 지뢰면, 진행하던 탐색 대신 지뢰맵(mineMap)을 출력하고 종료
        int[][] countMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(countMap[i], -1);
        }
        StringBuilder result = new StringBuilder();
        boolean isFailed = false;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (openMap[x][y] && !visitedOpen[x][y]) {
                    q.addLast(new int[]{x, y});
                    visitedOpen[x][y] = true;
                    boolean nowMine = false;
                    if (mineMap[x][y]) {
                        isFailed = true;
                        nowMine = true;
                    }

                    int count = 0;
                    for (int i = 0; i < 8; i++) {
                        int mx = x - dx[i];
                        int my = y - dy[i];

                        if (mx < 0 || my < 0 || n <= mx || n <= my) continue;
                        if (!mineMap[mx][my]) continue;

                        count++;
                    }

                    if (!nowMine) {
                        countMap[x][y] = count;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (countMap[i][j] != -1) {
                    result.append(countMap[i][j]);
                } else {
                    if(isFailed) {
                        if (mineMap[i][j]) {
                            result.append('*');
                        } else {
                            result.append('.');
                        }
                    } else {
                        result.append('.');
                    }
                }
            }
            result.append(System.lineSeparator());
        }

        System.out.println(result);
    }

}