import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<int[]>> map = IntStream.range(0, genres.length)
                .mapToObj(i -> new int[]{i, plays[i]})
                .collect(Collectors.groupingBy(i -> genres[i[0]]));

        List<String> keys = map.entrySet().stream()
                .sorted((a, b) -> {
                    int sumB = b.getValue().stream().mapToInt(arr -> arr[1]).sum();
                    int sumA = a.getValue().stream().mapToInt(arr -> arr[1]).sum();
                    return sumB - sumA;
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        for (String key : keys) {
            List<int[]> list = map.get(key);
            list.sort((a, b) -> b[1] - a[1]);
            result.add(list.get(0)[0]);
            if (list.size() > 1) {
                result.add(list.get(1)[0]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}