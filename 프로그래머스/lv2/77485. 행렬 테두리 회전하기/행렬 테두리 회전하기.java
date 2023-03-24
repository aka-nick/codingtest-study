import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {

        int[][] matrix = new int[rows + 1][columns + 1]; // one-based array
        int maxrixValue = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                matrix[i][j] = maxrixValue++;
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            // 시작좌표, 끝좌표 획득
            int[] query = queries[i];
            int startX = query[0];
            int startY = query[1];
            int endX = query[2];
            int endY = query[3];

            result[i] = rotate(matrix, startX, startY, endX, endY);
        }

        return result;
    }

    private int rotate(int[][] matrix, int startX, int startY, int endX, int endY) {
        // 회전 로직 구현부
        // 먼저 맨윗줄을 옮긴다고 해보자 : startX, startY =(y + 1)=> startX, endY
        int x = startX;
        int y = startY;
        int min = matrix[x][y];
        int tmp1 = matrix[x][y]; // 뽑은거
        int tmp2 = 0; // 뽑을거 (뽑은걸 꽂을 곳의 숫자)

        for (; y < endY; y++) {
            // 꽂기
            tmp2 = matrix[x][y + 1];
            matrix[x][y + 1] = tmp1;

            // 뽑기
            tmp1 = tmp2;

            // 최소 체크
            min = Math.min(min, tmp1);
        }

        // 그다음은 오른쪽 위에서 아래로 : startX, endY =(x + 1)=> endX, endY
        x = startX;
        y = endY;
        tmp1 = tmp2;
        for (; x < endX; x++) {
            // 꽂기
            tmp2 = matrix[x + 1][y];
            matrix[x + 1][y] = tmp1;

            // 뽑기
            tmp1 = tmp2;

            // 최소 체크
            min = Math.min(min, tmp1);
        }

        // 그담은 오른쪽 아래에서 왼쪽 아래로 : endX, endY =(y - 1)=> endX, startY
        x = endX;
        y = endY;
        tmp1 = tmp2;

        for (; startY < y; y--) {
            // 꽂기
            tmp2 = matrix[x][y - 1];
            matrix[x][y - 1] = tmp1;

            // 뽑기
            tmp1 = tmp2;

            // 최소 체크
            min = Math.min(min, tmp1);
        }

        // 마지막은 왼쪽 아래에서 왼쪽 위로 : endX, startY =(x - 1)=> startX, startY
        x = endX;
        y = startY;
        tmp1 = tmp2;

        for (; startX < x; x--) {
            // 꽂기
            tmp2 = matrix[x - 1][y];
            matrix[x - 1][y] = tmp1;

            // 뽑기
            tmp1 = tmp2;

            // 최소 체크
            min = Math.min(min, tmp1);
        }

        return min;
    }
    
}