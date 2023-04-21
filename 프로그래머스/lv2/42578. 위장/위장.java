import java.util.*;

class Solution {

    public int solution(String[][] clothes) {

        Map<String, Integer> clothMap = new HashMap<>();

        for (String[] cloth : clothes) {
            clothMap.put(cloth[1], clothMap.getOrDefault(cloth[1], 1) + 1);
        }

        int result = clothMap.keySet().stream()
                .map(key -> clothMap.get(key))
                .reduce(1, (a, b) -> a * b) - 1;

        return result;
    }
    
}