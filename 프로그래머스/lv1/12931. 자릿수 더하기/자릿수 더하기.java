import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public int solution(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        return IntStream.range(0, chars.length)
                .mapToObj(i -> chars[i])
                .mapToInt(c -> c - '0')
                .sum();
    }
}