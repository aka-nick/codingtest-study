import java.util.*;
import java.util.stream.*;

class Solution {

    public int solution(String[][] board, int h, int w) {
        int[] dx = {1, 0, -1 , 0};
        int[] dy = {0, 1, 0, -1};
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];
            if (nx < 0 || ny < 0 || board.length <= nx || board.length <= ny) {
                continue;
            }
            if (board[h][w].equals(board[nx][ny])) {
                count++;
            }
        }
        return count;
    }

}