import java.util.*;

class Solution {
    public int solution(int[][] routes) {

        Arrays.sort(routes, (Comparator.comparingInt(o -> o[1])));

        int countOfCam = 0;
        int lastPoint = -30001;
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];
            if (lastPoint < start) {
                countOfCam++;
                lastPoint = end;
            }
        }

        return countOfCam;
    }
}