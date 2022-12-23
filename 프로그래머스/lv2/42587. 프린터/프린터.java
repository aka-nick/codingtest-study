import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        List<int[]> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[]{i, priorities[i]});
        }
        int result = 0;

        // 루프를 돌면서
        //  이번 중요도와 나머지 중요도를 비교하여
        //      이번 중요도보다 큰 중요문서가 있으면 대기열 끝으로 삽입하고 다음 루프 진행
        //      이번 중요도보다 큰 중요문서가 없으면 출력
        //          출력할 문서의 '문서번호 == location'면 해당 루프의 반복횟수(result)를 리턴
        while (!q.isEmpty()) {
            result++;

            int[] nowDoc = q.remove(0);
            int nowDocNumber = nowDoc[0];
            int nowDocPriority = nowDoc[1];

            boolean reinputFlag = false;
            for (int i = 0; i < q.size(); i++) {
                int waitDocPriority = q.get(i)[1];
                if (nowDocPriority < waitDocPriority) {
                    reinputFlag = true;
                    break;
                }
            }
            if (reinputFlag) {
                result--;
                q.add(nowDoc);
            }
            else if (nowDocNumber == location) {
                break;
            }
        }

        return result;
    }
}