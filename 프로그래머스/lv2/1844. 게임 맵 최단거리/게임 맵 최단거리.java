import java.util.*;

class Solution {
    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[n][m];
        Deque<Position> q = new ArrayDeque<>();
        q.addLast(Position.create(0, 0));
        visited[0][0] = true;
        
        int step = 1;
        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            while (size-- > 0) {
                Position now = q.pollFirst();
                for (int i = 0; i < 4; i++) {
                    int nx = now.x - dx[i];
                    int ny = now.y - dy[i];
                    
                    if (nx < 0 || ny < 0 || n <= nx || m <= ny) continue;
                    if (visited[nx][ny]) continue;
                    if (maps[nx][ny] == 0) continue;
                    
                    if (nx == n - 1 && ny == m - 1) { // 종료 조건
                        return step;
                    }
                    
                    q.addLast(Position.create(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
    
    static class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public static Position create(int x, int y) {
            return new Position(x, y);
        }
    }
}