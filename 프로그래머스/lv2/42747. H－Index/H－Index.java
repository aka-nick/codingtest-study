import java.util.*;

class Solution {
    public int solution(int[] citations) { // 각 논문의 인용회수 배열
        // return : 인용회수보다 많은 논문이 존재하는 상황 중에서, 인용회수가 될 때의 값

        Arrays.sort(citations);

        int result = 0;
        for (int i = 0; i < citations.length; i++) {
            int countOfPaper = citations.length - i;
            int citation = citations[i];

            if (countOfPaper <= citation) {
                return countOfPaper;
            }
            
            if (1000 < citation) break;
        }

        return result;
    }
}