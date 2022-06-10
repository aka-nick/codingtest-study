import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
        public int solution(String begin, String target, String[] words) {
        // target이 words에 존재하지 않음 -> return 0;
        boolean targetNotFound = isTargetNotFound(target, words);
        if (targetNotFound) return 0;

        // 다시 구현 : n-1자가 같은지 비교하는 게 은근 귀찮다. 1글자만 틀린지(1글자 이상 틀리지 않았는지) 비교해보는 접근으로 가보자.
        String[] wrds = Arrays.copyOf(words, words.length + 1);
        wrds[wrds.length - 1] = begin;

        List<String>[] adjacent = new List[wrds.length];
        for (int i = 0; i < adjacent.length; i++) {
            adjacent[i] = new LinkedList<>();
        }

        // 2. 인접리스트 생성
        makeAdjacencyList(begin, wrds, adjacent);

        // 3. queue를 이용한 bfs 구현 - wrds 마지막 요소(begin)를 시작정점으로
        boolean[] visited = new boolean[wrds.length];
        Queue<String> q = new LinkedList<>();
        q.add(wrds[wrds.length - 1]);
        visited[wrds.length - 1] = true;
        int level = 0; // bfs 탐색의 레벨을 기록할 변수. return 될 값.
//        String lastWord = wrds[wrds.length - 1]; // 탐색할 레벨의 가장 마지막 단어. 이 단어가 poll 될 때 level++ 할 용도.

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- != 0) {
                String nowString = q.poll();
                if (nowString.equals(target)) break;

                int nowIdx = getWordIdx(wrds, nowString);

                for (int i = 0; i < adjacent[nowIdx].size(); i++) {
                    String vertex = adjacent[nowIdx].get(i);
                    int nextWordIdx = getWordIdx(wrds, vertex);
                    if (!visited[nextWordIdx]) {
                        q.add(vertex);
                        visited[nextWordIdx] = true;
                    }
                }
                System.out.println("nowString = " + nowString);
            }
            level++;
        }

        level--; //맨 처음 단어(begin)로 인한 스텝은 빼주기.

        return level;
    }

    private boolean isTargetNotFound(String target, String[] words) {
        boolean targetNotFound = true;
        for (String w : words) {
            if (w.equals(target)) targetNotFound = false;
        }
        return targetNotFound;
    }

    private int getWordIdx(String[] wrds, String findWord) {
        int idx = -1;
        for (int i = 0; i < wrds.length; i++) { //idx를 찾는 무식한 방법.. 개선이 필요.
            if (wrds[i].equals(findWord)) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    private void makeAdjacencyList(String begin, String[] wrds, List<String>[] adjacent) {
        int charLength = begin.length();
        // 'i번째 단어'와 'j번째 단어'의 'k번째 글자'를 반복해나가면서 간선 여부를 파악한다
        for (int i = 0; i < wrds.length - 1; i++) { //마지막 단어는 비교할 다음 단어가 없다.
            for (int j = i + 1; j < wrds.length; j++) {
                int diff = 0;
                for (int k = 0; k < charLength; k++) {
                    if (wrds[i].charAt(k) != wrds[j].charAt(k)) diff++;
                    if (2 <= diff) break;
                }
                if (diff == 1) { // 현 단어와 다음 단어 간의 차이가 한 글자인 경우
                    adjacent[i].add(wrds[j]);
                    adjacent[j].add(wrds[i]);
                }
            }
        }
    }

}