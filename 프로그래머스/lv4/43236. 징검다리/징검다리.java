import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int l = 1;
        int r = distance;
        while (l <= r) {
            int x = (l + r) / 2;

            if (isExceeded(x, rocks, distance, n)) {
                l = x + 1;
            }
            else {
                if (r == x) break;
                r = x;
            }
        }

        return r - 1;
    }

    private boolean isExceeded(int x, int[] rocks, int distance, int n) {
        /*
        * 조건: 0 ~ rocks ~ distance 중에서, x만큼의 텀이 있어? (rocks n개까지 건너뛰기 가능)
        *   x만큼의 텀이 안되면 : return false
        * */
        int removableRockCount = n;

        int datum = 0; // 거리를 잴 기준점. 맨 처음엔 시작점0 ~ 첫돌 사이 거리를 재야하니까, 0으로 초기화.
        for (int i = 0; i < rocks.length; i++) {
            if (0 < removableRockCount && rocks.length - removableRockCount <= i) { // 거의 끝쪽인데 뺄 돌이 남아있으면, 무조건 빼준다
                removableRockCount--;
                continue;
            }
            else if (betweenSize(datum, rocks[i]) < x) {
                if (0 < removableRockCount--)
                    continue;
                else
                    return false;
            }
            datum = rocks[i];
        }
        if (betweenSize(datum, distance) < x) return false; //끝돌 ~ 끝점distance 사이 거리를 재야하니까, 재준다.

        return true;
    }

    private int betweenSize(int datum, int rocks) {
        return rocks - datum;
    }
}