import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = IntStream.range(0, name.length)
                .boxed()
                .collect(Collectors.toMap(i -> name[i], i -> yearning[i]));

        List<Integer> list = Arrays.stream(photo)
                .map(pt -> Arrays.stream(pt)
                        .mapToInt(p -> map.getOrDefault(p, 0))
                        .sum())
                .collect(Collectors.toList());

        return list.stream().mapToInt(i -> i).toArray();
    }
}