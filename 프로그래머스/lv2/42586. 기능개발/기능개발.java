import java.util.*;
import java.util.stream.*;

class Solution {

    public int[] solution(int[] progresses, int[] speeds) {

        Deque<int[]> q = new ArrayDeque();

        for (int i = 0; i < progresses.length; i++) {
            q.addLast(new int[]{progresses[i], speeds[i]});
        }

        List<Integer> resultList = new ArrayList<>();
        int days = 0;
        while (!q.isEmpty()) {
            days++;

            workOn(q.peekFirst());

            int countOfDeploy = 0;
            while (!q.isEmpty() && isDone(q.peekFirst()[0])) {
                countOfDeploy = deploy(q, countOfDeploy);

                while (!q.isEmpty()) {
                    int[] ints = q.peekFirst();
                    for (int i = 0; i < days; i++) {
                        workOn(q.peekFirst());
                        if (!q.isEmpty() && isDone(q.peekFirst()[0])) {
                            countOfDeploy = deploy(q, countOfDeploy);
                            break;
                        }
                    }
                    if (ints == q.peekFirst()) break;
                }
            }
            if (0 < countOfDeploy) {
                resultList.add(countOfDeploy);
            }

        }

        return resultList.stream().mapToInt(i->i).toArray();
    }
    void workOn(int[] work) {
        work[0] += work[1];
    }
    boolean isDone(int progress) {
        return 100 <= progress;
    }
    int deploy(Deque<int[]> works, int countOfDeploy) {
        works.pollFirst();
        return countOfDeploy + 1;
    }
}