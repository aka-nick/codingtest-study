import java.util.*;
import java.util.stream.*;
import java.math.*;
import java.util.Map.*;
class Solution {
    public int solution(int k, int[] tangerine) {

        Map<Integer, Integer> frequent = new HashMap<>();
        for (int i : tangerine) {
            frequent.put(i, frequent.getOrDefault(i, 0) + 1);
        }

        List<Entry<Integer, Integer>> list = frequent.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            k -= list.get(i).getValue();

            if (k <= 0) {
                return ++i;
            }
        }
        return -1;
    }

}