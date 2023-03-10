import java.util.*;

class Solution {
    public Integer[] solution(String msg) {

        List<Integer> answer = new ArrayList<>();
        String input = new String(msg);
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            dict.put(String.valueOf(input.charAt(i)), input.charAt(i)-'A' + 1);
        }

        int idx = 27;

        //입력이 비어있지 않으면
        while (!input.isEmpty()) {

            // 입력의 첫번째 문자부터
            int findIdx = 0;
            for (int i = 1; i <= input.length(); i++) {
                String now = input.substring(0, i); // +i번째 문자 까지를

                // 사전에서 찾는다
                    // 있으면 i++하며 계속 찾고
                    // 없으면 0 ~ i-1 문자열를 출력하기 위한 이후 작업을 진행한다
                if (!dict.containsKey(now)) break;
                findIdx = i;
            }

            //문자열 출력
            int printValue = dict.get(input.substring(0, findIdx));
            answer.add(printValue);

            //사전에 새문자열 추가
            if (findIdx + 1 <= input.length()) {
                dict.put(input.substring(0, findIdx + 1), idx++);
            }

            //출력한 문자열을 입력문자열에서 제거
            input = input.substring(findIdx);
        }

        return answer.stream().toArray(Integer[]::new);
    }
}