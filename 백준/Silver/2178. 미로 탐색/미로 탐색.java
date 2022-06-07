import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] maze;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) break;

            char[] carr = line.toCharArray();
            for (int j = 0; j < m; j++) {
                maze[i][j] = carr[j] == '1' ? 1 : 0;
            }
        }
        br.close();

        find(0, 0);
    }

    private static void find(int x, int y) {
        Queue<Room> bfsQueue = new LinkedList<>();
        visitNewRoom(bfsQueue, 1, x, y);

        while (!bfsQueue.isEmpty()) {
            Room room = bfsQueue.poll();
            int nowX = room.getX();
            int nowY = room.getY();

            if (nowX == n - 1 && nowY == m - 1) { // 목적지에 도착했다면
                System.out.println(room.getStep()); // 현재 step 출력하고 종료.
                return;
            }

            if (0 < nowX
                    && maze[nowX - 1][nowY] == 1) {
                visitNewRoom(bfsQueue, room.getNextStep(), nowX - 1, nowY);
            }
            if (nowX < n - 1
                    && maze[nowX + 1][nowY] == 1) {
                visitNewRoom(bfsQueue, room.getNextStep(), nowX + 1, nowY);
            }
            if (0 < nowY
                    && maze[nowX][nowY - 1] == 1) {
                visitNewRoom(bfsQueue, room.getNextStep(), nowX, nowY - 1);
            }
            if (nowY < m - 1
                    && maze[nowX][nowY + 1] == 1) {
                visitNewRoom(bfsQueue, room.getNextStep(), nowX, nowY + 1);
            }

        }
    }

    private static void visitNewRoom(Queue<Room> bfsQueue, int room, int nowX, int nowY) {
        bfsQueue.add(new Room(room, nowX, nowY));
        maze[nowX][nowY]++;
    }

}
class Room {
    private final int posStep;
    private final int posX;
    private final int posY;
    
    public Room(int step, int x, int y) {
        posStep = step;
        posX = x;
        posY = y;
    }
    public int getX() { return posX; }
    public int getY() { return posY; }
    public int getStep() { return posStep; }
    public int getNextStep() { return posStep + 1; }
}