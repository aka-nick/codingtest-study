import java.util.*;

class Solution {
    public int solution(String str1, String str2) {

        // 알파벳만 남기기 - 미리 알파벳만 남기면 안됨
//            str1 = str1.replaceAll("[^a-zA-Z]", "");
//            str2 = str2.replaceAll("[^a-zA-Z]", "");

        // 소문자만 남기기
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 집합 만들기
        Map<String, Integer> map1 = new HashMap<>();
        makeSet(str1, map1);
        Map<String, Integer> map2 = new HashMap<>();
        makeSet(str2, map2);

        // 예외 처리 : 둘 다 공집합
        if (map1.size() == 0 && map2.size() == 0) {
            return 65536;
        }

        // 교집합 카운트 & 꺼내기
        int numberOfIntersection = 0;
        String[] elements = map1.keySet().toArray(String[]::new);
        for (int i = 0; i < elements.length; i++) {
            String nowElement = elements[i];
            while (map1.containsKey(nowElement)) {
                if (!map2.containsKey(nowElement)) {
                    break;
                }

                // 교집합 발견
                numberOfIntersection++; // 카운트
                // 체크한 교집합은 기존 집합에서 제거
                int calcOfElementOfMap1 = map1.get(nowElement) - 1;
                int calcOfElementOfMap2 = map2.get(nowElement) - 1;
                if (calcOfElementOfMap1 == 0) {
                    map1.remove(nowElement);
                }
                else {
                    map1.put(nowElement, calcOfElementOfMap1);
                }
                if (calcOfElementOfMap2 == 0) {
                    map2.remove(nowElement);
                }
                else {
                    map2.put(nowElement, calcOfElementOfMap2);
                }
            }
        }

        // 합집합 세기
        int numberOfUnion = calcUnion(map1) + calcUnion(map2) + numberOfIntersection;

        // 자카드 점수 계산
        double jacquardSimilarity = (double) numberOfIntersection / (double) numberOfUnion;

        // 출력값 계산
        int result = (int) Math.floor(jacquardSimilarity * (double)65536);
        return result;
    }

    private int calcUnion(Map<String, Integer> map) {
        int numberOfUnion = 0;
        for (String element : map.keySet()) {
            numberOfUnion += map.get(element);
        }
        return numberOfUnion;
    }

    private void makeSet(String str, Map<String, Integer> map) {
        for (int pos = 0; pos < str.length() - 1; pos++) {
            String nowSubstring = str.substring(pos, pos + 2);
            if (nowSubstring.length() != nowSubstring.replaceAll("[^a-z]", "").length()) continue;
            map.put(nowSubstring, map.getOrDefault(nowSubstring, 0) + 1);
        }
    }
}